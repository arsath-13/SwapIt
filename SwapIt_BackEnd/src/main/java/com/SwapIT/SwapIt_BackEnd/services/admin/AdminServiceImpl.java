package com.SwapIT.SwapIt_BackEnd.services.admin;

import com.SwapIT.SwapIt_BackEnd.dto.CategoryDto;
import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;
import com.SwapIT.SwapIt_BackEnd.entities.Category;
import com.SwapIT.SwapIt_BackEnd.entities.Product;
import com.SwapIT.SwapIt_BackEnd.repository.CategoryRepository;
import com.SwapIT.SwapIt_BackEnd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(Category::getCategoryDto).collect(Collectors.toList());
    }


    @Override
    public Product postProduct(Long category_id, ProductDto productDto) throws IOException {
        Optional<Category> optionalCategory = categoryRepository.findById(category_id);
        if(optionalCategory.isPresent()) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setStatus(productDto.getStatus());
            product.setImage(productDto.getImage().getBytes());
            product.setCategory(optionalCategory.get());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::getProductDto).collect(Collectors.toList());
    }
}
