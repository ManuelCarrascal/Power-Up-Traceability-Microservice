package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Order;

import java.util.List;

public interface IOrderTraceabilityPersistencePort {
    void createOrderTraceability(Order order);
    List<Order> getOrdersByClientId(Long clientId);

}
