package com.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "store name is required")
    private String storeName;

    @NotEmpty(message = "store name is required")
    private String storeNameOwner;

    @NotEmpty(message = "city is required")
    private String city;
    @NotEmpty(message = "district is required")
    private String district;

    @NotEmpty(message = "street is required")
    private String street;
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;

    @NotEmpty(message = "email number is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "company register certification number is required")
    private String companyRegisterUrl;
    private boolean isActive; // by admin
    private String commercialLicense;

    //  Relationships

    @ManyToMany(mappedBy = "stores")
    private List<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store_owner")
    private List<Product> productList;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser store_user;


}
