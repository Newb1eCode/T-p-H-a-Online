package com.example.assigmentjava6.controller.api;

import com.example.assigmentjava6.entities.Account;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.service.AccountService;
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
@RequestMapping("api/account")
public class AccountApiController {

    @Autowired
    private AccountService serAccount;

    @GetMapping
    public List<Account> getRole(){
        return serAccount.findAll();
    }

    @PostMapping
    public Account createApi(@RequestBody Account account){
        return serAccount.save(account);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Account> getAccountid(@PathVariable String id){
        Account account = serAccount.findByid(id)
                .orElseThrow();
        return ResponseEntity.ok(account);
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> getUpdate(@PathVariable String id,@RequestBody Account account){
        Account account1 = serAccount.findByid(id)
                .orElseThrow();
        account1.setFullname(account.getFullname());
        serAccount.save(account1);
        return ResponseEntity.ok(account1);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Account> getDeleteid(@PathVariable String id){
        Account account = serAccount.findByid(id)
                .orElseThrow();
        serAccount.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
