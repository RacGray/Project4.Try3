package org.example.controller;


import org.example.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProductService;

import java.util.List;

@RestController
public class ProductController
{
    ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping("seller/{id}products")
    public ResponseEntity<Product> addProduct(@RequestBody Product p, @PathVariable long id) throws Exception{
        Product product = productService.saveProduct(id, p);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
