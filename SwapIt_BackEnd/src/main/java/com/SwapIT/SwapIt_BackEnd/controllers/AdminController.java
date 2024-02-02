package com.SwapIT.SwapIt_BackEnd.controllers;

import com.SwapIT.SwapIt_BackEnd.dto.CategoryDto;
import com.SwapIT.SwapIt_BackEnd.dto.ProductDto;
import com.SwapIT.SwapIt_BackEnd.entities.Category;
import com.SwapIT.SwapIt_BackEnd.entities.Product;
import com.SwapIT.SwapIt_BackEnd.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.PrimitiveIterator;


@CrossOrigin(origins = "http://localhost:4200",
        allowedHeaders = "Authorization")
@RestController
@RequestMapping("api/admin")



public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
        Category createdCategory = adminService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);

    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories = adminService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @PostMapping("/product/{category_id}")
    public ResponseEntity<Product> postProduct(@PathVariable Long category_id, @ModelAttribute ProductDto productDto) throws IOException {
        Product postedProduct = adminService.postProduct(category_id,productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(postedProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList=adminService.getAllProducts();
        return ResponseEntity.ok (productDtoList);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        adminService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id) {
        ProductDto productDto = adminService.getProductById(id);
        if(productDto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDto);
    }

    @PutMapping ("/{category_id}/product/{productId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long category_id,
            @PathVariable Long productId,
            @ModelAttribute ProductDto productDto
    ) throws IOException {
        ProductDto updatedProduct = adminService.updateProduct(category_id,productId,productDto);
        if(updatedProduct==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");

        }
        return ResponseEntity.ok(updatedProduct);
    }

}
