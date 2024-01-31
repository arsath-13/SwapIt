package com.SwapIT.SwapIt_BackEnd.services.admin;

import com.SwapIT.SwapIt_BackEnd.dto.CategoryDto;
import com.SwapIT.SwapIt_BackEnd.entities.Category;

import java.util.List;

public interface AdminService {
    Category createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
}
