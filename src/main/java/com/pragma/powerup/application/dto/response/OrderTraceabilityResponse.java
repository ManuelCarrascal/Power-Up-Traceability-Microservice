package com.pragma.powerup.application.dto.response;

import com.pragma.powerup.domain.model.StatusChange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTraceabilityResponse {

    private String id;

    private Long idRestaurant;

    private List<StatusChange> statusChanges;
}