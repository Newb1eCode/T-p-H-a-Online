package com.example.assigmentjava6.controller.admin;

import com.example.assigmentjava6.entities.Product;
import com.example.assigmentjava6.service.CategoryService;
import com.example.assigmentjava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService serProduct;

    @Autowired
    private CategoryService serCategory;

    @GetMapping("Product-home")
    public String index(Model mol, @RequestParam("p")Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(0),5);
        Page<Product> productPage = serProduct.findAll(pageable);
        if(!mol.containsAttribute("sp")){
        mol.addAttribute("sp",productPage);}
        return "/product/index";
    }

    @GetMapping("Product-delete/{id}")
    public String delelte(@PathVariable Long id){
        serProduct.delete(id);
        return "redirect: Product-home";
    }

    @GetMapping("Product-detail/{id}")
    public String detail(@PathVariable Long id,Model mol){
        mol.addAttribute("sp",serProduct.findById(id));
        return "redirect: Product-home";
    }

    @GetMapping("Product-viewAdd")
    public String viewAdd(Model mol){
        mol.addAttribute("product",new Product());
        mol.addAttribute("");
        return "product/add";
    }

    @PostMapping("Product-add")
    public String create(@ModelAttribute Product product){
        product.setCreateDate(new Date());
        serProduct.saveProduct(product);
        return "redirect: Product-home";
    }

    @GetMapping("Product-find")
    public String find(@RequestParam(value = "name",required = false) String name,Model mol,
                       @RequestParam("p") Optional<Integer> page){
        int currentPage = page.orElse(0);
        Page<Product> productPage;
        if (name == null || name.isEmpty()){
            Pageable pageable = PageRequest.of(currentPage, 5);
            productPage = serProduct.findAll(pageable);
        }else {
            Pageable pageable = PageRequest.of(currentPage, 5);
            productPage = serProduct.findByname(name, pageable);
        }
        mol.addAttribute("sp",productPage);
        return "product/index";
    }


}


