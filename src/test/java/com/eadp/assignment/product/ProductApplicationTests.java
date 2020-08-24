package com.eadp.assignment.product;

import com.eadp.assignment.product.controller.ProductController;
import com.eadp.assignment.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductApplicationTests {
   @Autowired
	ProductController pc;
   @Autowired
	ProductService productService;
	@Test
	void contextLoads() {
		productService.grantProduct(101);

	}

}
