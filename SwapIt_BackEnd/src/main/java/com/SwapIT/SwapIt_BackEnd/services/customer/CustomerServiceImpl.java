package com.SwapIT.SwapIt_BackEnd.services.customer;

import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;
import com.SwapIT.SwapIt_BackEnd.entities.Product;
import com.SwapIT.SwapIt_BackEnd.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::getProductDto).collect(Collectors.toList());
    }
}
