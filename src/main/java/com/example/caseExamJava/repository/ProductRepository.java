package com.example.caseExamJava.repository;

import com.example.caseExamJava.DTO.ProductDTO;
import com.example.caseExamJava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, Integer> {
}
