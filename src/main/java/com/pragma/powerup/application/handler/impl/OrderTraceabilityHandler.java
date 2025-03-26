package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.OrderTraceabilityRequest;
import com.pragma.powerup.application.dto.response.OrderTraceabilityResponse;
import com.pragma.powerup.application.handler.IOrderTraceabilityHandler;
import com.pragma.powerup.application.mapper.IOrderTraceabilityMapper;
import com.pragma.powerup.domain.api.IOrderTraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderTraceabilityHandler implements IOrderTraceabilityHandler {

    private final IOrderTraceabilityServicePort orderTraceabilityServicePort;
    private final IOrderTraceabilityMapper orderTraceabilityMapper;

    @Override
    public void createOrderTraceability(OrderTraceabilityRequest orderTraceabilityRequest) {
        orderTraceabilityServicePort.createOrderTraceability(orderTraceabilityMapper.toOrderTraceability(orderTraceabilityRequest));
    }

    @Override
    public List<OrderTraceabilityResponse> getClientOrderHistory() {
        return orderTraceabilityServicePort.getClientOrderHistory().stream()
                .map(orderTraceabilityMapper::toOrderTraceabilityResponse)
                .collect(Collectors.toList());
    }
}
