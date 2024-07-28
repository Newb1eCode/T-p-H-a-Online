package com.example.assigmentjava6.controller.api;

import com.example.assigmentjava6.entities.Order;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.service.OrderService;
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
@RequestMapping("api/order")
public class OrderApiController {

    @Autowired
    private OrderService serOrder;

    @GetMapping
    public List<Order> getOrders(){
        return serOrder.findAll();
    }

    @PostMapping
    public Order createApi(@RequestBody Order order){
        return serOrder.save(order);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Order> getOrderid(@PathVariable Long id){
        Order order = serOrder.findByid(id)
                .orElseThrow();
        return ResponseEntity.ok(order);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> getUpdate(@PathVariable Long id,@RequestBody Order order){
        Order order1 = serOrder.findByid(id)
                .orElseThrow();
        order1.setAddress(order.getAddress());
        serOrder.save(order1);
        return ResponseEntity.ok(order1);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Order> getDeleteid(@PathVariable Long id){
        Order order = serOrder.findByid(id)
                .orElseThrow();;
        serOrder.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
