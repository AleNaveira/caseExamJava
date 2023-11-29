package com.example.caseExamJava.service;

import com.example.caseExamJava.DTO.ProductDTO;
import com.example.caseExamJava.model.Product;

import java.util.List;
import java.util.Optional;

public interface ShoppingCart {
    void addProduct (ProductDTO product);
    void removeProduct(Integer productId);
    List<ProductDTO> viewCart();
    double calculateTotalPrice();
    boolean idIsValid(Integer productId);




}
