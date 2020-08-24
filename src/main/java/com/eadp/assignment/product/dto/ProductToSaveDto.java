package com.eadp.assignment.product.dto;

import lombok.*;


public class ProductToSaveDto {
    private Integer productId;
    private String productName;
    private Integer productInternalId;
    private String franchise;
    private int count;

    public ProductToSaveDto(Integer productId, String productName, Integer productInternalId, String franchise, int count) {
        this.productId = productId;
        this.productName = productName;
        this.productInternalId = productInternalId;
        this.franchise = franchise;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
