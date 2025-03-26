package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Order;
import com.pragma.powerup.domain.model.OrderDish;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderDishEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dishes", target = "orderDishes")
    OrderEntity toEntity(Order order);

    @Mapping(source = "orderDishes", target = "dishes")
    Order toOrder(OrderEntity orderEntity);

    OrderDish toOrderDish(OrderDishEntity entity);
    OrderDishEntity toOrderDishEntity(OrderDish domain);
}