package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Category;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.CategoryRepository;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repoCategory;

    public List<Category> findAll(){
        return repoCategory.findAll();
    }

    public Category save(Category category){
        return repoCategory.save(category);
    }

    public void delete(String id){
        repoCategory.deleteById(id);
    }

    public Optional<Category> findByid(String id){
        return repoCategory.findById(id);
    }

}
