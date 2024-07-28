package com.example.assigmentjava6.controller.api;

import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.exception.ResourceNotFoundException;
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
@RequestMapping("api/role")
public class RoleApiController {

    @Autowired
    private RoleService serRole;

    @GetMapping
    public List<Role> getRole(){
        return serRole.findAll();
    }

    @PostMapping
    public Role createApi(@RequestBody Role role){
        return serRole.save(role);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Role> getRoleid(@PathVariable String id){
        Role role = serRole.findByid(id)
                .orElseThrow();
        return ResponseEntity.ok(role);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> getUpdate(@PathVariable String id,@RequestBody Role role){
        Role role1 = serRole.findByid(id)
                .orElseThrow();
        role1.setName(role.getName());
        serRole.save(role1);
        return ResponseEntity.ok(role1);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Role> getDeleteid(@PathVariable String id){
        Role role = serRole.findByid(id)
                .orElseThrow();
        serRole.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
