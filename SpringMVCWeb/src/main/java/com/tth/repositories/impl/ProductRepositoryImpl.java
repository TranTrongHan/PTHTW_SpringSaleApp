/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.repositories.impl;


import com.tth.pojo.Category;
import com.tth.pojo.Product;
import com.tth.repositories.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    private static final int PAGE_SIZE = 6;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
            Session s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> query = b.createQuery(Product.class);
            Root root = query.from(Product.class);
            query.select(root);

            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("kw");
                if (kw != null && !kw.isEmpty()) {
                    predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
                }
                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
                }
                
                String cateId = params.get("cateId");
                if(cateId!=null && !cateId.isEmpty()){
                    predicates.add(b.equal(root.get("category").as(Integer.class), cateId));
                }

                query.where(predicates.toArray(Predicate[]::new));
            }
            Query q = s.createQuery(query);
            
            if(params!= null){
                String page = params.get("page");
                if(page!= null){
                    int p = Integer.parseInt(page);
                    int start = (p-1) * PAGE_SIZE;
                    
                    q.setFirstResult(start);
                    q.setMaxResults(PAGE_SIZE);
                }
            }
            
            return q.getResultList();
        
    }
    
    @Override
    public Product getProductById(int id){
        Session s = this.factory.getObject().getCurrentSession();
            return s.get(Product.class,id);
        
    }
    
    @Override
    public void addOrUpdateProduct(Product p){
        Session s = this.factory.getObject().getCurrentSession();
            if(p.getId() == null){
                s.persist(p);
            } else {
                s.merge(p);
            }
        
    }
//    
//    public void deleteProduct(int id){
//        // Phai canh bao hoac phan tich nghiep vu ro rang co xoa luon thang  lien quan hay khong hoac giu lai => User thay ro canh bao khi xoa
//        try(Session s = HibernateConfigs.getFACTORY().openSession()){
//            Product p = this.getProductById(id);
//            s.remove(p);
//        }
//    }

    
}
