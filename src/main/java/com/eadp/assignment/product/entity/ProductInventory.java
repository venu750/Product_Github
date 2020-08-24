package com.eadp.assignment.product.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Product Inventory Id")
    private int inventoryId;
    @ApiModelProperty(value = "Product Id")
    private Integer  productId;
    @ApiModelProperty(value = "Original Product Quantity")
    private int originalQuantity;
    @ApiModelProperty(value = "Avilable Prodyct Quantity")
    private int availableQuantity;
    @CreationTimestamp
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @ApiModelProperty(value = "Product Created Date")
    private LocalDateTime createdDate;
    @CreationTimestamp
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @ApiModelProperty(value = "Product Modified  Date")
    private LocalDateTime modifiedDate;

    public ProductInventory(){

    }
    public ProductInventory(Integer productId, int originalQuantity, int availableQuantity) {
        this.productId = productId;
        this.originalQuantity = originalQuantity;
        this.availableQuantity = availableQuantity;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
