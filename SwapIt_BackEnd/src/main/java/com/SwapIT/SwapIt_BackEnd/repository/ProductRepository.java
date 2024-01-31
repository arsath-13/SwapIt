package com.SwapIT.SwapIt_BackEnd.repository;

import com.SwapIT.SwapIt_BackEnd.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
