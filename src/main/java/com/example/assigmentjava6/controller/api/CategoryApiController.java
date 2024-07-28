package com.example.assigmentjava6.controller.api;

import com.example.assigmentjava6.entities.Category;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.service.CategoryService;
import com.example.assigmentjava6.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryApiController {

    @Autowired
    private CategoryService serCategory;

    @GetMapping
    public List<Category> getCategories(){
        return serCategory.findAll();
    }

    @PostMapping
    public Category createApi(@RequestBody Category category){
        return serCategory.save(category);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Category> getCategoryid(@PathVariable String id){
        Category category = serCategory.findByid(id)
                .orElseThrow();
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> getUpdate(@PathVariable String id,@RequestBody Category category){
        Category category2 = serCategory.findByid(id)
                .orElseThrow();
        category2.setName(category.getName());
        return ResponseEntity.ok(category2);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Category> getDeleteid(@PathVariable String id){
        Category category2 = serCategory.findByid(id)
                .orElseThrow();
        serCategory.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
