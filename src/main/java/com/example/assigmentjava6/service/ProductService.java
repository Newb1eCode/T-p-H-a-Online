package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Product;
import com.example.assigmentjava6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repoPro;

    public List<Product> findAllapi(){
        return repoPro.findAll();
    }

    public Page<Product> findAll(Pageable pageable){
        return repoPro.findAll(pageable);
    }

    public Product saveProduct(Product product){
        return repoPro.save(product);
    }

    public void delete(Long id){
    repoPro.deleteById(id);
    }

    public Optional<Product>findById(Long id){
        return repoPro.findById(id);
    }

}
