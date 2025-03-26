package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.OrderTraceabilityRequest;
import com.pragma.powerup.application.dto.response.OrderTraceabilityResponse;

import java.util.List;

public interface IOrderTraceabilityHandler {

    void createOrderTraceability(OrderTraceabilityRequest orderTraceabilityRequest);

    List<OrderTraceabilityResponse> getClientOrderHistory();


}
