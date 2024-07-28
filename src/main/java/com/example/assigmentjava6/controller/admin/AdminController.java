package com.example.assigmentjava6.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @GetMapping ("Admin-home")
    public String admin(){
        return"/admin/index";
    }

}
