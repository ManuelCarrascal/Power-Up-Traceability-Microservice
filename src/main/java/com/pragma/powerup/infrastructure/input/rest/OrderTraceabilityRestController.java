package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.OrderTraceabilityRequest;
import com.pragma.powerup.application.dto.response.OrderTraceabilityResponse;
import com.pragma.powerup.application.handler.IOrderTraceabilityHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/traceability")
@RequiredArgsConstructor
@Tag(name = "Order Traceability", description = "API for managing order traceability")
public class OrderTraceabilityRestController {

    private final IOrderTraceabilityHandler orderTraceabilityHandler;

    @Operation(summary = "Create order traceability record",
            description = "Creates a new order traceability record in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order traceability created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "403", description = "Not authorized to create traceability")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrderTraceability(@Valid @RequestBody OrderTraceabilityRequest orderTraceabilityRequest) {
        orderTraceabilityHandler.createOrderTraceability(orderTraceabilityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get client order history",
            description = "Retrieves the order history for the authenticated client",
            security = @SecurityRequirement(name = "JWT"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order history retrieved successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = OrderTraceabilityResponse.class))
                    )),
            @ApiResponse(responseCode = "403", description = "Not authorized to access the history"),
            @ApiResponse(responseCode = "404", description = "No order history found")
    })
    @GetMapping(value = "/client/history", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<List<OrderTraceabilityResponse>> getClientOrderHistory() {
        return ResponseEntity.ok(orderTraceabilityHandler.getClientOrderHistory());
    }
}