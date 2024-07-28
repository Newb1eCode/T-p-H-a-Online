package com.example.assigmentjava6.controller.api;

import com.example.assigmentjava6.entities.Order;
import com.example.assigmentjava6.entities.OrderDetail;
import com.example.assigmentjava6.entities.Role;
import com.example.assigmentjava6.service.OrderDetailService;
import com.example.assigmentjava6.service.OrderService;
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
@RequestMapping("api/orderdetail")
public class OrderDetailApiController {

    @Autowired
    private OrderDetailService serOrderDetail;

    @GetMapping
    public List<OrderDetail> getOrdersDetails(){
        return serOrderDetail.findAll();
    }

    @PostMapping
    public OrderDetail createApi(@RequestBody OrderDetail orderDetail){
        return serOrderDetail.save(orderDetail);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<OrderDetail> getOrderid(@PathVariable Long id){
        OrderDetail orderDetail = serOrderDetail.findByid(id)
                .orElseThrow();
        return ResponseEntity.ok(orderDetail);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDetail> getUpdate(@PathVariable Long id,@RequestBody OrderDetail orderDetail){
        OrderDetail order1 = serOrderDetail.findByid(id)
                .orElseThrow();
        order1.setPrice(orderDetail.getPrice());
        serOrderDetail.save(order1);
        return ResponseEntity.ok(order1);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<OrderDetail> getDeleteid(@PathVariable Long id){
        OrderDetail orderDetail = serOrderDetail.findByid(id)
                .orElseThrow();;
        serOrderDetail.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
