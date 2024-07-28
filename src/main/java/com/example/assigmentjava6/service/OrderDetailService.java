package com.example.assigmentjava6.service;

import com.example.assigmentjava6.entities.OrderDetail;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.repository.OrderDetailRepository;
import com.example.assigmentjava6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository repoOrderDetail;

    public List<OrderDetail> findAll(){
        return repoOrderDetail.findAll();
    }

    public OrderDetail save(OrderDetail orderDetail){
        return repoOrderDetail.save(orderDetail);
    }

    public void delete(Long id){
        repoOrderDetail.deleteById(id);
    }

    public Optional<OrderDetail> findByid(Long id){
        return repoOrderDetail.findById(id);
    }

}
