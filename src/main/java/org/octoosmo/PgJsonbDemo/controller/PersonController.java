package org.octoosmo.pgJsonbDemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.octoosmo.pgJsonbDemo.mapper.PersonMapper;
import org.octoosmo.pgJsonbDemo.model.Person;
import org.octoosmo.pgJsonbDemo.model.request.PersonCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.PersonSearchRequest;
import org.octoosmo.pgJsonbDemo.model.request.PersonUpdateRequest;
import org.octoosmo.pgJsonbDemo.model.response.PersonResponse;
import org.octoosmo.pgJsonbDemo.service.PersonService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@Tag(name = "Person controller", description = "Person API")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Returns a person",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Person has been found.",
                            content = @Content(schema = @Schema(implementation = PersonResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create person",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public PersonResponse get(@PathVariable UUID id) {
        var person = personService.find(id);
        return PersonMapper.INSTANCE.personToPersonResponse(person);
    }

    @PostMapping
    @Operation(summary = "Creates a new person",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PersonCreateRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Person create request",
                                            value = """
                                                    {
                                                      "name":"Alex",
                                                      "email":"alex@mail.com",
                                                      "address":"street",
                                                      "phone":"+0123456789",
                                                      "customAttributesJson":{
                                                        "favoriteHotels": ["Marriott", "Hilton", "Wyndham", "Choice"]
                                                      }
                                                    }
                                                    """)
                            }
                    ),
                    description = "person"
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "New person has been created.",
                            content = @Content(schema = @Schema(implementation = PersonResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create person",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public PersonResponse create(@RequestBody PersonCreateRequest request) {
        var person = personService.create(PersonMapper.INSTANCE.personCreateRequestToPerson(request));
        return PersonMapper.INSTANCE.personToPersonResponse(person);
    }

    @PostMapping("/search")
    @Operation(summary = "Searches for a person",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PersonSearchRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Person search request",
                                            value = """
                                                    {
                                                      "ids": ["16b3ff48-5891-43a7-abf1-ff194f22106d"],
                                                      "names":["Alex"],
                                                      "emails":["alex@mail.com"],
                                                      "addresses":["street"],
                                                      "phones":["+0123456789"],
                                                      "customAttributesJson": {
                                                        "isPremium": true
                                                      },
                                                      "custom_attributes_jsons": [
                                                      {
                                                        "favoriteHotels": ["Marriott", "Hilton", "Wyndham", "Choice"]
                                                      },
                                                      {
                                                        "favoriteHotels": ["Marriott", "Hilton", "Wyndham"],
                                                        "secondName": "Oleg"
                                                      },
                                                      {
                                                        "hasDiscount": true
                                                      }
                                                     ]
                                                    }
                                                    """)
                            }
                    ),
                    description = "person search request"
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Person has been found.",
                            content = @Content(schema = @Schema(implementation = PersonResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create person",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<List<Person>> search(
            @RequestBody
            PersonSearchRequest personSearchRequest,
            @SortDefault.SortDefaults({@SortDefault(sort = "name", direction = Sort.Direction.DESC)})
            @ParameterObject
            Pageable pageable) {
        var personPage = personService.search(personSearchRequest, pageable);
        if (personPage.getNumber() + 1 < personPage.getTotalPages()) {
            return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(personPage.getContent());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(personPage.getContent());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Rewrites person",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = PersonCreateRequest.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Person update request",
                                            value = """
                                                    {
                                                      "name":"Alex",
                                                      "email":"alex@mail.com",
                                                      "address":"street 2",
                                                      "phone":"+0123456789",
                                                      "customAttributesJson":{
                                                        "additionalProp1":{"inner":"value2"},
                                                        "additionalProp2":{"inner":"value3"},
                                                        "additionalProp3":{}
                                                      }
                                                    }
                                                    """)
                            }
                    ),
                    description = "person"
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Person has been rewritten.",
                            content = @Content(schema = @Schema(implementation = PersonResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create person",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public PersonResponse update(@RequestBody PersonUpdateRequest request, @PathVariable UUID id) {
        var person = PersonMapper.INSTANCE.personUpdateRequestToPerson(request);
        person.setId(id);
        person = personService.update(person);
        return PersonMapper.INSTANCE.personToPersonResponse(person);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes person",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Person has been deleted.",
                            content = @Content(schema = @Schema(implementation = PersonResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create person",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    public void delete(@PathVariable UUID id) {
        personService.delete(id);
    }
}
