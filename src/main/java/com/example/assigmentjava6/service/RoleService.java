package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repoRole;

    public List<Role> findAll(){
        return repoRole.findAll();
    }

    public Role save(Role role){
        return repoRole.save(role);
    }

    public void delete(String id){
        repoRole.deleteById(id);
    }

    public Optional<Role> findByid(String id){
        return repoRole.findById(id);
    }

}
