package com.grupp3.grupp3mvc.controller;


import com.grupp3.grupp3mvc.CRUDRepository;
import com.grupp3.grupp3mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    CRUDRepository dbcrud;

    public Product AddToCart(int id) {
        return dbcrud.findById(id).get();
    }

    public Product GetTempProduct(int id) {
        return dbcrud.findById(id).get();
    }

    public boolean SetTrigger(boolean trigger) {
        return !trigger;
    }

    public Product CheckProduct(Product product) {
        Product tempProduct = new Product();

        if(product != null) {
            tempProduct = product;
        }

        return tempProduct;
    }

}
