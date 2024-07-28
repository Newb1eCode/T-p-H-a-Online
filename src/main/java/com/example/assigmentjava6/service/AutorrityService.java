package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Authority;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.AccountRepository;
import com.example.assigmentjava6.repository.AuthorityRepository;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorrityService {
    @Autowired
    private AuthorityRepository repoAuthor;

    public List<Authority> findAll(){
        return repoAuthor.findAll();
    }

    public Authority save(Authority authority){
        return repoAuthor.save(authority);
    }

    public void delete(Long id){
        repoAuthor.deleteById(id);
    }

    public Optional<Authority> findByid(Long id){
        return repoAuthor.findById(id);
    }
}
