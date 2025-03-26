package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.pragma.powerup.domain.model.StatusChange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String id;
    private Long idClient;
    private Long idRestaurant;
    private Long idEmployee;
    private List<OrderEntity> orderDishes;
    private List<StatusChange> statusChanges;
}
