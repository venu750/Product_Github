package com.eadp.assignment.product.service;

import com.eadp.assignment.product.dto.ProductDto;
import com.eadp.assignment.product.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertorService {
    @Autowired
    private ModelMapper modelMapper;
    public ProductDto convertToDto(Product product){
        return modelMapper.map(product,ProductDto.class);
    }

}

