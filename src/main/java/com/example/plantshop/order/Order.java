package com.example.plantshop.order;

import com.example.plantshop.appuser.AppUser;
import com.example.plantshop.orderitems.OrderItems;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postalCode;
    private String street;
    private String city;
    private String phoneNumber;
    private Date createdDate;
    private double totalPrice;
    private String status;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @OneToMany(mappedBy = "order")
    private List<OrderItems> itemsOrders;
}
