package com.example.caseExamJava.controller;


import com.example.caseExamJava.DTO.ProductDTO;
import com.example.caseExamJava.model.CouponDiscount;
import com.example.caseExamJava.model.Product;
import com.example.caseExamJava.service.ShoppingCartImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import javax.validation.*;
import java.util.List;

@RestController
@RequestMapping("/carrito")
@Validated
public class ShoppingCartController {


    private final ShoppingCartImpl shoppingCartImpl;

    CouponDiscount couponDiscount = new CouponDiscount();


    @Autowired
    public ShoppingCartController(ShoppingCartImpl shoppingCartImpl) {

        this.shoppingCartImpl = shoppingCartImpl;

    }


    @GetMapping("/ver-productos")
    public ResponseEntity<List<ProductDTO>> viewCart() {
        return ResponseEntity.ok(shoppingCartImpl.viewCart());

    }


    @PostMapping("/crear-producto")
    public ResponseEntity<String> addToCart(@RequestBody @Valid ProductDTO product) {

        shoppingCartImpl.addProduct(product);

        return new ResponseEntity<>("Se ha añadido el producto al carrito", HttpStatus.CREATED);
    }

    @PostMapping("/eliminar-producto/{productId}")
    public ResponseEntity removeFromCart(@Valid @PathVariable Integer productId) {

        if (productId == null || !shoppingCartImpl.idIsValid(productId)) {

            return new ResponseEntity<>("Id de producto no válido", HttpStatus.BAD_REQUEST);
        }

        shoppingCartImpl.removeProduct(productId);


        return new ResponseEntity<>("Se ha eliminado el producto del carrito", HttpStatus.OK);

    }


    @GetMapping("/total")
    public ResponseEntity calculateTotalPrice() {

        double totalPrice = shoppingCartImpl.calculateTotalPrice();

        return ResponseEntity.ok(totalPrice);
    }


    @PostMapping("/aplicar-descuento")
    public ResponseEntity<String> applyDiscount(@RequestParam String discountType) {
        List<ProductDTO> productList = shoppingCartImpl.viewCart();


        if ("DISCOUNT10".equals(discountType)) {
            couponDiscount.applyDiscount10(productList);

        } else if ("DISCOUNT25".equals(discountType)) {


        } else if ("DISCOUNT30".equals(productList)) {
            couponDiscount.applyDiscount30(productList);

        } else {
            return new ResponseEntity<>("Tipo de descuento no válido", HttpStatus.OK);
        }


        return new ResponseEntity<>("El descuento " + discountType + " se ha aplicado al carrito", HttpStatus.OK);
    }


    @GetMapping("/ver-carritoprecio")
    public ResponseEntity viewCartPrice() {

        return ResponseEntity.ok(shoppingCartImpl.viewTotalPriceCart());
    }


}