package com.SwapIT.SwapIt_BackEnd.controllers;

import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;
import com.SwapIT.SwapIt_BackEnd.services.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList=customerService.getAllProducts();
        return ResponseEntity.ok (productDtoList);
    }
}
