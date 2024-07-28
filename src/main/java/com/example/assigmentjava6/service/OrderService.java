package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.Order;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.OrderRepository;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {

    @Autowired
    private OrderRepository repoOrder;

    public List<Order> findAll(){
        return repoOrder.findAll();
    }

    public Order save(Order order){
        return repoOrder.save(order);
    }

    public void delete(Long id){
        repoOrder.deleteById(id);
    }

    public Optional<Order> findByid(Long id){
        return repoOrder.findById(id);
    }

}
