package org.octoosmo.PgJsonbDemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.octoosmo.PgJsonbDemo.mapper.PersonMapper;
import org.octoosmo.PgJsonbDemo.request.PersonCreateRequest;
import org.octoosmo.PgJsonbDemo.request.PersonUpdateRequest;
import org.octoosmo.PgJsonbDemo.response.PersonResponse;
import org.octoosmo.PgJsonbDemo.service.PersonService;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

@RestController
@RequestMapping("/person")
@Tag(name = "person controller", description = "Person API")
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
                                                      "custom_attributes_json":{
                                                        "additionalProp1":{"inner1":"value1"},
                                                        "additionalProp2":{},
                                                        "additionalProp3":{}
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
                                                      "custom_attributes_json":{
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
    public PersonResponse update(@RequestBody PersonUpdateRequest request, @PathVariable UUID id)
            throws InvocationTargetException, IllegalAccessException {
        var person = PersonMapper.INSTANCE.personUpdateRequestToPerson(request).withId(id);
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
