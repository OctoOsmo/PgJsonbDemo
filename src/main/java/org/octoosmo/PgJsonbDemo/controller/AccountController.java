package org.octoosmo.pgJsonbDemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.octoosmo.pgJsonbDemo.mapper.AccountMapper;
import org.octoosmo.pgJsonbDemo.model.request.AccountCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.AccountUpdateRequest;
import org.octoosmo.pgJsonbDemo.model.response.AccountResponse;
import org.octoosmo.pgJsonbDemo.service.AccountService;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@Tag(name = "Account controller", description = "Account API")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Returns an account",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Account has been found.",
                            content = @Content(schema = @Schema(implementation = AccountResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create account",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public AccountResponse get(@PathVariable UUID id) {
        var account = accountService.find(id);
        return AccountMapper.INSTANCE.accountToAccountResponse(account);
    }

    @PostMapping
    @Operation(
            summary = "Creates a new account",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = AccountCreateRequest.class), examples = @ExampleObject(
                            name = "Account create request", value = """
                            {
                              "personId":"47b249f3-3c04-4cd7-8aba-c55a9c1c80b1",
                              "currency":"EUR",
                              "balance":"245.66",
                              "customAttributesJson":{
                                "special_offers": [
                                  {
                                    "title": "New Customer Discount",
                                    "description": "Get 20% off your first purchase with code NEWCUSTOMER20."
                                  }
                                ],
                                "personal_manager": "Emily Smith",
                                "notes": [
                                  {
                                    "title": "Loan Application",
                                    "description": "Submit your loan application by the end of the week to get approved in time."
                                  }
                                ],
                                "additional_options": [
                                  {
                                    "name": "Foreign Currency Exchange",
                                    "description": "Exchange your currency to another with a fee of 2%."
                                  }
                                ]
                                }
                            }
                            """)
                    ), description = "account"
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "New account has been created.",
                            content = @Content(schema = @Schema(implementation = AccountResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create account",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    public AccountResponse create(@RequestBody AccountCreateRequest request) {
        var account = accountService.create(request);
        return AccountMapper.INSTANCE.accountToAccountResponse(account);

    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Rewrites account",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(implementation = AccountCreateRequest.class), examples = @ExampleObject(
                            name = "Account update request", value = """
                            {
                              "personId":"47b249f3-3c04-4cd7-8aba-c55a9c1c80b1",
                              "currency":"EUR",
                              "balance":"245.66",
                              "customAttributesJson":{
                                "special_offers": [
                                  {
                                    "title": "New Customer Discount",
                                    "description": "Get 20% off your first purchase with code NEWCUSTOMER20."
                                  }
                                ],
                                "personal_manager": "Emily Smith",
                                "notes": [
                                  {
                                    "title": "Loan Application",
                                    "description": "Submit your loan application by the end of the week to get approved in time."
                                  }
                                ],
                                "additional_options": [
                                  {
                                    "name": "Foreign Currency Exchange",
                                    "description": "Exchange your currency to another with a fee of 2%."
                                  }
                                ]
                                }
                            }
                            """)),
                    description = "account"
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Account has been rewritten.",
                            content = @Content(schema = @Schema(implementation = AccountResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create account",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))}
    )
    public AccountResponse update(
            @RequestBody AccountUpdateRequest request,
            @PathVariable UUID id
    ) {
        var account = accountService.update(id, request);
        return AccountMapper.INSTANCE.accountToAccountResponse(account);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes account",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Account has been deleted.",
                            content = @Content(schema = @Schema(implementation = AccountResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "401", description = "User is not authenticated",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "403", description = "User is not allowed to create account",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))}
    )
    public void delete(@PathVariable UUID id) {
        accountService.delete(id);
    }
}
