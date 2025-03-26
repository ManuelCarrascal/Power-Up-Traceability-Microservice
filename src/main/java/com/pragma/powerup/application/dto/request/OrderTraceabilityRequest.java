package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.domain.model.OrderDish;
import com.pragma.powerup.domain.model.StatusChange;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating order traceability information")
public class OrderTraceabilityRequest {

    @Schema(description = "Unique identifier for the order", example = "1001")
    private Long id;

    @Schema(description = "Client's unique identifier", example = "5001", required = true)
    private Long idClient;

    @Schema(description = "Employee's unique identifier who processed the order", example = "3001")
    private Long idEmployee;

    @Schema(description = "Restaurant's unique identifier", example = "2001", required = true)
    private Long idRestaurant;

    @Schema(description = "List of dishes included in the order", required = true)
    private List<OrderDish> dishes;

    @Schema(description = "History of status changes for the order")
    private List<StatusChange> statusChanges;
}