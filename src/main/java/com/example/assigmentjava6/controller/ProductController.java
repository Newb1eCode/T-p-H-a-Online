package com.example.assigmentjava6.controller;

import com.example.assigmentjava6.entities.Product;
import com.example.assigmentjava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService serProduct;

    @GetMapping("/home")
    public String index(Model mol, @RequestParam("p")Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(0),3);
        Page<Product> productPage = serProduct.findAll(pageable);
        if(!mol.containsAttribute("sp")){
        mol.addAttribute("sp",productPage);}
        return "product/index";
    }

}
