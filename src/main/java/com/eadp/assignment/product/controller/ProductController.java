package com.eadp.assignment.product.controller;

import com.eadp.assignment.product.dto.ProductDto;
import com.eadp.assignment.product.dto.ProductToSaveDto;
import com.eadp.assignment.product.entity.Product;
import com.eadp.assignment.product.service.ConvertorService;
import com.eadp.assignment.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Configuration
@RestController
@Api(value = "Api for Product-Store")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    ConvertorService convertorService;
    @ApiOperation(value = "Api returns all products")
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos=productService.getAllProducts();
        if(productDtos.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity(productDtos,HttpStatus.OK);
    }
    @ApiOperation(value = "Api returns product based on Id")
    @GetMapping("product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Integer id) {
        if(productService.productCheckById(id)){
            return new ResponseEntity(productService.getProductById(id),HttpStatus.OK);
        }
        return new ResponseEntity("Product with that id not exists",HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Api returns multiple products based on ids")
    @GetMapping(value="/productByIds")
    public List<ProductDto> getProductsByIds(@RequestParam("productIds") List<Integer> productIds){
        return productService.getProdByIds(productIds);
    }

    @ApiOperation(value = "Api adds product to DB")
    @PostMapping("product/add")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductToSaveDto ps) {
        return  new ResponseEntity(productService.addProduct(ps),HttpStatus.OK);
    }

    @ApiOperation(value = "Api updates the product")
    @PutMapping("product/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,
                                           @RequestBody Product product) {

        System.out.println("the output of product check is"+productService.productCheckById(id));
        if(productService.productCheckById(id)==true){
            productService.updateProduct(id, product);
            return new ResponseEntity("product updated successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("product is not present",HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Api deletes the product based on Id")
    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        //  return playerService.deleteProduct(id);
        if(productService.productCheckById(id)){
            productService.deleteProductById(id);
            return new ResponseEntity("product deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity("product with that id not exists",HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Api grants the product to player")
    @PostMapping("/product/{productId}/grant")
    public ResponseEntity grantProduct(@PathVariable("productId")Integer productId){
        boolean productExists=productService.productCheckById(productId);
        if(productExists==false)
            return new ResponseEntity("product is not possible to grant",HttpStatus.NOT_FOUND);
        boolean res=productService.grantProduct(productId);
        if(res==false)
            return new ResponseEntity("product grant is not possible",HttpStatus.NOT_FOUND);
        else {
            return new ResponseEntity("product granted successfully", HttpStatus.OK);
        }
    }
}
