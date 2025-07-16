/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tth.services.impl;

import com.tth.pojo.Cart;
import com.tth.repositories.ReceiptRepository;
import com.tth.services.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepository receiptRepo;
    @Override
    public void addReceipt(List<Cart> carts) {
        this.receiptRepo.addReceipt(carts);
    }
    
}
