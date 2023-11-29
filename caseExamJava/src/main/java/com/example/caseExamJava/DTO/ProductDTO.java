package com.example.caseExamJava.DTO;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="El nombre del producto no debe estar vacío")
    @NotBlank
    private String name;
    @NotNull(message="El producto debe contener una descripción")
    @NotBlank
    private String description;


    @NotNull(message="El producto debe tener un precio")
    @NotBlank
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

