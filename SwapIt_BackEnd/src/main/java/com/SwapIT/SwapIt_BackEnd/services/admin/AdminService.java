package com.SwapIT.SwapIt_BackEnd.services.admin;

import com.SwapIT.SwapIt_BackEnd.dto.CategoryDto;
import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;
import com.SwapIT.SwapIt_BackEnd.entities.Category;
import com.SwapIT.SwapIt_BackEnd.entities.Product;

import java.io.IOException;
import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    Product postProduct(Long category_id, ProductDto productDto) throws IOException;

    List<ProductDto> getAllProducts();
}
