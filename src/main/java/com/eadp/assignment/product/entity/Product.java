package com.eadp.assignment.product.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
    @Id
            @ApiModelProperty(value = "Product Id")
    Integer productId;
    @ApiModelProperty(value = "Product Name")
    String productName;
    @ApiModelProperty(value = "Product Internal Id")
    Integer productInternalId;
    @ApiModelProperty(value = "Product franchise")
    String franchise;
    public Product(Integer productId, String productName, Integer productInternalId, String franchise) {
        this.productId = productId;
        this.productName = productName;
        this.productInternalId = productInternalId;
        this.franchise = franchise;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductInternalId() {
        return productInternalId;
    }

    public void setProductInternalId(Integer productInternalId) {
        this.productInternalId = productInternalId;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }
}
