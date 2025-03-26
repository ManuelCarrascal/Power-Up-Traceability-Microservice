package com.pragma.powerup.application.dto.response;

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
@Schema(description = "Response object containing order traceability information")
public class OrderTraceabilityResponse {

    @Schema(description = "Unique identifier for the order", example = "60f1a5c2e8d7b318945c9c23")
    private String id;

    @Schema(description = "Restaurant's unique identifier", example = "2001")
    private Long idRestaurant;

    @Schema(description = "History of status changes for the order")
    private List<StatusChange> statusChanges;
}