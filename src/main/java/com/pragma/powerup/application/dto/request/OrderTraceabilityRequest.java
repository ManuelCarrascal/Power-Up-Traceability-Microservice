package com.pragma.powerup.application.dto.request;

import com.pragma.powerup.domain.model.OrderDish;
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
public class OrderTraceabilityRequest {

    private Long id;

    private Long idClient;

    private Long idEmployee;

    private Long idRestaurant;

    private List<OrderDish> dishes;

    private List<StatusChange> statusChanges;

}
