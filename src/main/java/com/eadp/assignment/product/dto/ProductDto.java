package com.eadp.assignment.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    @JsonIgnore
    Integer productId;
    String productName;
    @JsonIgnore
    String productInternalId;
    String franchise;
}
