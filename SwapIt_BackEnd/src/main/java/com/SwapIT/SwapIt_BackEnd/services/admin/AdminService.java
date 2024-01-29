package com.SwapIT.SwapIt_BackEnd.services.admin;

import com.SwapIT.SwapIt_BackEnd.dto.CategoryDto;
import com.SwapIT.SwapIt_BackEnd.entities.Category;

public interface AdminService {
    Category createCategory(CategoryDto categoryDto);
}
