package com.example.assigmentjava6.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CategoryController {

    @GetMapping("Category-home")
    public String home(){
        return "category/index";
    }

}
