package com.example.assigmentjava6.controller;

import com.example.assigmentjava6.entities.Product;
import com.example.assigmentjava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
        product.setCreateDate(new Date());
        return serProduct.saveProduct(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getproductById(@PathVariable long id){
        Product product = serProduct.findById(id)
                .orElseThrow();
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> getUpdateproductById(@PathVariable long id, @RequestBody Product product){
        Product productUpdate = serProduct.findById(id)
                .orElseThrow();
        productUpdate.setAvailable(product.getAvailable());
        productUpdate.setName(product.getName());
        productUpdate.setCategory(product.getCategory());
        productUpdate.setImage(product.getImage());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setCreateDate(new Date());

        serProduct.saveProduct(productUpdate);
        return ResponseEntity.ok(productUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> getDeleteproductById(@PathVariable long id){
        Product productDelete = serProduct.findById(id)
                .orElseThrow();

        serProduct.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
