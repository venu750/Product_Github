package com.eadp.assignment.product.repository;

import com.eadp.assignment.product.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory,Integer> {
    @Query("select p from ProductInventory p where p.productId =?1")
    ProductInventory getById(Integer productId);
}
