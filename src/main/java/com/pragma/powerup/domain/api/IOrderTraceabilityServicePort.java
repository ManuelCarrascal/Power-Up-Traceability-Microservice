package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Order;

import java.util.List;

public interface IOrderTraceabilityServicePort {

    void createOrderTraceability(Order order);

    List<Order> getClientOrderHistory();

}
