package com.SwapIT.SwapIt_BackEnd.services.customer;

import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;

import java.util.List;

public interface CustomerService {
    List<ProductDto> getAllProducts();
}
