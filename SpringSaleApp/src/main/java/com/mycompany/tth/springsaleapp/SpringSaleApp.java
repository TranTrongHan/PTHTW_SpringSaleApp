/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tth.springsaleapp;

import com.tth.repositories.impl.CategoryRepositoryImpl;
import com.tth.repositories.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class SpringSaleApp {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s= new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));

        ProductRepositoryImpl p = new ProductRepositoryImpl();
//          p.getProducts(null).forEach(pro -> System.out.printf("%d - %s - %1.f\n",pro.getId(),pro.getName(),pro.getPrice()));
        Map<String, String> params = new HashMap<>();
        params.put("page", "1");
        p.getProducts(params).forEach(pro -> pro.show());
        
        
        

    }
}
