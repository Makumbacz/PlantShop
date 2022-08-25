package com.example.plantshop.cart;


import com.example.plantshop.appuser.AppUser;
import com.example.plantshop.plant.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    private int quantity;
  /*  @ManyToOne
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;
    @JsonIgnore
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    @OneToOne(targetEntity = AppUser.class)
    private AppUser appUser;*/
  public Cart(Plant plant, Integer quantity, AppUser appUser) {
    /*  this.plant = plant;
      this.appUser = appUser;*/
      this.quantity = quantity;
      this.createdDate = new Date();
  }
}
