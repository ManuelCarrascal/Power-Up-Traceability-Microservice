package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Order;
import com.pragma.powerup.domain.spi.IOrderTraceabilityPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IOrderEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IOrderTraceabilityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderTraceabilityJpaAdapter implements IOrderTraceabilityPersistencePort {
    private final IOrderEntityMapper orderEntityMapper;
    private final IOrderTraceabilityRepository orderTraceabilityRepository;

    @Override
    public void createOrderTraceability(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        orderEntity.setId(order.getId().toString());
        orderTraceabilityRepository.save(orderEntity);
    }

    @Override
    public List<Order> getOrdersByClientId(Long clientId) {
        return orderTraceabilityRepository.findByIdClient(clientId)
                .stream()
                .map(orderEntityMapper::toOrder)
                .collect(Collectors.toList());
    }
}
