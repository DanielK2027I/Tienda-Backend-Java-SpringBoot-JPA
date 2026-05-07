package com.tienda.service.TiendaBackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="products")
public class Product {
    @Column(name= "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false)
    private Long id;

    @Column(name="stock")
    private Integer stock;

    public Product (){

    }

    public Product(String name, Double price, Long id, Integer stock) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
