/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.controllers;

import com.tth.pojo.Category;
import com.tth.services.CategoryService;
import com.tth.services.ProductService;
import jakarta.persistence.Query;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService cateService;
    @Autowired
    private ProductService prodService;
    
    @Transactional
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("msg" , "HELLO OU");
        model.addAttribute("products",this.prodService.getProducts(params));
        model.addAttribute("categories",this.cateService.getCates());
        return "index";
    }
}
