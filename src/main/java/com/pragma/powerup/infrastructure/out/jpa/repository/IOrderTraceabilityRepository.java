package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderTraceabilityRepository extends MongoRepository<OrderEntity, Long> {
    OrderEntity findById(String id);
    List<OrderEntity> findByIdClient(Long idClient);

}
