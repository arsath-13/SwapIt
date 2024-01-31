package com.SwapIT.SwapIt_BackEnd.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private MultipartFile image;
    private Boolean status = true;

    private byte[] returnedImage;
    private Long categoryId;
    private String categoryName;
}
