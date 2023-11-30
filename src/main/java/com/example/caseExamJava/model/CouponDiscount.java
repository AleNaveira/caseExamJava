package com.example.caseExamJava.model;

import com.example.caseExamJava.DTO.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CouponDiscount {



    public void applyDiscount10(List<ProductDTO> productList){

        productList.forEach(product-> product.setPrice(product.getPrice()*0.9));

    }

    public void applyDiscount25(List<ProductDTO> productList){
        productList.forEach(product-> product.setPrice(product.getPrice()*0.75));
    }

    public void applyDiscount30(List<ProductDTO> productList){
        productList.forEach(product-> product.setPrice(product.getPrice()*0.7));
    }

}

