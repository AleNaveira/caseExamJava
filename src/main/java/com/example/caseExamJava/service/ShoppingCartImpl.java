package com.example.caseExamJava.service;

import com.example.caseExamJava.DTO.ProductDTO;
import com.example.caseExamJava.model.Product;
import com.example.caseExamJava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartImpl implements ShoppingCart {


    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }


    @Override
    public void addProduct(ProductDTO product) {
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Integer productId) {
        productRepository.deleteById(productId);

    }

    @Override
    public List<ProductDTO> viewCart() {
        return productRepository.findAll();
    }

    @Override
    public double calculateTotalPrice() {
        List<ProductDTO> products = productRepository.findAll();
        return products.stream().mapToDouble(ProductDTO::getPrice).sum();


    }

    public boolean idIsValid(Integer productId) {

        Optional<ProductDTO> product = productRepository.findById(productId);
        return product.isPresent();

    }

    public String viewTotalPriceCart(){
        List<ProductDTO> products = productRepository.findAll();
        Double totalPriceCart = products.stream().mapToDouble(ProductDTO::getPrice).sum();

        return "El precio total del carrito es " + totalPriceCart;
    }



}

