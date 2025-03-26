package com.pragma.powerup.domain.model;

public class OrderDish {

    private Long id;
    private Long idDish;
    private Integer quantity;



    public OrderDish(Long id, Long idDish, Integer quantity) {
        this.id = id;
        this.idDish = idDish;
        this.quantity = quantity;
    }

    public OrderDish() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
