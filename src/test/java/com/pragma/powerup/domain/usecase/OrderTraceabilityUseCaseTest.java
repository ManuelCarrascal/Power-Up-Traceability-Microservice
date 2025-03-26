package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Order;
import com.pragma.powerup.domain.model.OrderDish;
import com.pragma.powerup.domain.model.StatusChange;
import com.pragma.powerup.domain.spi.IOrderTraceabilityPersistencePort;
import com.pragma.powerup.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderTraceabilityUseCaseTest {

    @Mock
    private IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort;

    @Mock
    private IUserPersistencePort userPersistencePort;

    private OrderTraceabilityUseCase orderTraceabilityUseCase;

    @BeforeEach
    void setUp() {
        orderTraceabilityUseCase = new OrderTraceabilityUseCase(
                orderTraceabilityPersistencePort,
                userPersistencePort
        );
    }

    @Test
    void createOrderTraceability_shouldCallPersistencePort() {
        Order order = createSampleOrder();

        orderTraceabilityUseCase.createOrderTraceability(order);

        verify(orderTraceabilityPersistencePort, times(1)).createOrderTraceability(order);
    }

    @Test
    void getClientOrderHistory_shouldReturnOrdersForCurrentUser() {
        Long userId = 1L;
        List<Order> expectedOrders = Arrays.asList(createSampleOrder(), createSampleOrder());

        when(userPersistencePort.getCurrentUserId()).thenReturn(userId);
        when(orderTraceabilityPersistencePort.getOrdersByClientId(userId)).thenReturn(expectedOrders);

        List<Order> result = orderTraceabilityUseCase.getClientOrderHistory();

        assertEquals(expectedOrders, result);
        verify(userPersistencePort, times(1)).getCurrentUserId();
        verify(orderTraceabilityPersistencePort, times(1)).getOrdersByClientId(userId);
    }

    @Test
    void getClientOrderHistory_shouldReturnEmptyListWhenNoOrders() {
        Long userId = 1L;
        List<Order> expectedOrders = new ArrayList<>();

        when(userPersistencePort.getCurrentUserId()).thenReturn(userId);
        when(orderTraceabilityPersistencePort.getOrdersByClientId(userId)).thenReturn(expectedOrders);

        List<Order> result = orderTraceabilityUseCase.getClientOrderHistory();

        assertEquals(expectedOrders, result);
        verify(userPersistencePort, times(1)).getCurrentUserId();
        verify(orderTraceabilityPersistencePort, times(1)).getOrdersByClientId(userId);
    }

    private Order createSampleOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setIdClient(1L);
        order.setIdEmployee(2L);
        order.setIdRestaurant(3L);

        List<OrderDish> dishes = new ArrayList<>();
        OrderDish dish = new OrderDish();
        dish.setId(1L);
        dish.setIdDish(101L);
        dish.setQuantity(2);
        dishes.add(dish);
        order.setDishes(dishes);

        List<StatusChange> statusChanges = new ArrayList<>();
        StatusChange statusChange = new StatusChange();
        statusChange.setStatus("PENDING");
        statusChanges.add(statusChange);
        order.setStatusChanges(statusChanges);

        return order;
    }
}