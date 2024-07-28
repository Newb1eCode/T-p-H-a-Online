package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Account;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.AccountRepository;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repoAccount;

    public List<Account> findAll(){
        return repoAccount.findAll();
    }

    public Account save(Account account){
        return repoAccount.save(account);
    }

    public void delete(String id){
        repoAccount.deleteById(id);
    }

    public Optional<Account> findByid(String id){
        return repoAccount.findById(id);
    }
}
