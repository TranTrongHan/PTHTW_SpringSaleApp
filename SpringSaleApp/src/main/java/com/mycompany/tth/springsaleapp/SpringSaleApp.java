/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tth.springsaleapp;

import com.tth.repositories.impl.CategoryRepositoryImpl;
import com.tth.repositories.impl.ProductRepositoryImpl;
import com.tth.repositories.impl.StatsRepositoryImpl;
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
//        Map<String, String> params = new HashMap<>();
//        params.put("page", "1");
//        p.getProducts(params).forEach(prod -> System.out.printf("%d - %s - %s\n",prod.getId(),prod.getName(),prod.getPrice()));
        StatsRepositoryImpl stats = new StatsRepositoryImpl();
//            stats.statsRevenueByProduct().forEach(o -> System.out.printf("%d - %s - %d\n",o[0],o[1],o[2]));
        stats.statsRevenueByTime("MONTH", 2020).forEach(o -> System.out.printf("%d - %d\n", o[0], o[1]));

    }
}
