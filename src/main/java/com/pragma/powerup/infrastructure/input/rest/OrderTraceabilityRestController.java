package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.OrderTraceabilityRequest;
import com.pragma.powerup.application.dto.response.OrderTraceabilityResponse;
import com.pragma.powerup.application.handler.IOrderTraceabilityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/traceability")
@RequiredArgsConstructor
public class OrderTraceabilityRestController {

    private final IOrderTraceabilityHandler orderTraceabilityHandler;


    @PostMapping
    public ResponseEntity<Void> createOrderTraceability(@Valid @RequestBody OrderTraceabilityRequest orderTraceabilityRequest) {
        orderTraceabilityHandler.createOrderTraceability(orderTraceabilityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/client/history")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<List<OrderTraceabilityResponse>> getClientOrderHistory() {
        return ResponseEntity.ok(orderTraceabilityHandler.getClientOrderHistory());
    }
}
