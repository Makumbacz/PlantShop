package com.example.plantshop.orderitems;

import com.example.plantshop.order.Order;
import com.example.plantshop.plant.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @NotNull
    private double price;
    @NotNull
    private Integer quantity;
    @OneToOne
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;
    @ManyToOne
    @JsonIgnore
    private Order order;


    public OrderItems(Integer price, Plant plant, Order order, Integer quantity) {
        this.date = new Date();
        this.price = price;
        this.plant = plant;
        this.order = order;
        this.quantity = quantity;
    }
}