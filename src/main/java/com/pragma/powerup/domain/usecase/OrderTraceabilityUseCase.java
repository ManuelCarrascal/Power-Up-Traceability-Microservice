package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IOrderTraceabilityServicePort;
import com.pragma.powerup.domain.model.Order;
import com.pragma.powerup.domain.spi.IOrderTraceabilityPersistencePort;
import com.pragma.powerup.domain.spi.IUserPersistencePort;

import java.util.List;

public class OrderTraceabilityUseCase implements IOrderTraceabilityServicePort {

    private final IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort;
    private final IUserPersistencePort userPersistencePort;

    public OrderTraceabilityUseCase(IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort, IUserPersistencePort userPersistencePort) {
        this.orderTraceabilityPersistencePort = orderTraceabilityPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public void createOrderTraceability(Order order) {
        orderTraceabilityPersistencePort.createOrderTraceability(order);
    }

    @Override
    public List<Order> getClientOrderHistory() {
        Long currentUserId = userPersistencePort.getCurrentUserId();
        return orderTraceabilityPersistencePort.getOrdersByClientId(currentUserId);
    }
}
