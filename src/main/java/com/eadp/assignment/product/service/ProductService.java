package com.eadp.assignment.product.service;

import com.eadp.assignment.product.dto.ProductDto;
import com.eadp.assignment.product.dto.ProductToSaveDto;
import com.eadp.assignment.product.entity.Product;
import com.eadp.assignment.product.entity.ProductInventory;
import com.eadp.assignment.product.repository.ProductInventoryRepository;
import com.eadp.assignment.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ConvertorService convertorService;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    public boolean productCheckById(Integer id){
        return productRepository.existsById(id);
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products =productRepository.findAll();
        return products.stream().map(convertorService::convertToDto).collect(Collectors.toList());
    }

    public List<ProductDto> getProdByIds(List<Integer> productIds) {
        List<Product> products=productRepository.findAllById(productIds);
        return products.stream().map(convertorService::convertToDto).collect(Collectors.toList());
    }

    public ProductDto getProductById(Integer id){
        Product product =productRepository.findById(id).orElse(null);
        return convertorService.convertToDto(product);
    }

    public ProductDto addProduct(ProductToSaveDto ps){
       Product product= productRepository.save(new Product(ps.getProductId(),ps.getProductName(),ps.getProductInternalId(),ps.getFranchise()));
       ProductInventory productInventory = productInventoryRepository.save(new ProductInventory(ps.getProductId(),ps.getCount(),ps.getCount()));
       return convertorService.convertToDto(product);
    }
    public Product updateProduct(Integer id, Product product){
        productRepository.deleteById(id);
        productRepository.flush();
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
    }
    public boolean grantProduct(Integer productId){
        System.out.println("entering into grant");
        LocalDateTime now = LocalDateTime.now();
        ProductInventory productInventory=productInventoryRepository.getById(productId);//getProductById(productId);

        if(productInventory.getAvailableQuantity()<=0){
            System.out.println("prodcts are over");
            return false;
        }
        else if(productInventory.getOriginalQuantity()>=productInventory.getAvailableQuantity()
                && productInventory.getAvailableQuantity()>0)
        {
            System.out.println("product available quantity "+productInventory.getAvailableQuantity());
            productInventory.setAvailableQuantity(productInventory.getAvailableQuantity()-1);
            productInventory.setModifiedDate(now);
            productInventoryRepository.save(productInventory);
            return true;
        }
        return false;
    }


}
