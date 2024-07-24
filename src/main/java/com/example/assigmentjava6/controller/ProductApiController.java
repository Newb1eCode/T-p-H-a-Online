package com.example.assigmentjava6.controller;

import com.example.assigmentjava6.entities.Product;
import com.example.assigmentjava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductApiController {

    @Autowired
    private ProductService serProduct;

    @GetMapping
    public List<Product> getallProduct(){
        return serProduct.findAllapi();
    }

    @PostMapping
    public Product createApi(@RequestBody Product product){
        return serProduct.saveProduct(product);
    }

}
