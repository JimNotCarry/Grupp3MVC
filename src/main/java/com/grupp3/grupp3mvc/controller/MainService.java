package com.grupp3.grupp3mvc.controller;


import com.grupp3.grupp3mvc.CRUDRepository;
import com.grupp3.grupp3mvc.model.Product;
import org.aspectj.util.PartialOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    CRUDRepository dbcrud;

    ArrayList<Product> serviceCart = new ArrayList<>();

    public ArrayList<Product> AddToCart(int id, ArrayList<Product> cart) {

        try {
            cart.add(dbcrud.findById(id).get());
        } catch (Exception e) {
            System.out.println(e);
        }

        return cart;
    }

    public Product GetTempProduct(int id) {
        Product product = new Product();
        try {
            product = dbcrud.findById(id).get();
        } catch (Exception e) {
            System.out.println(e);
        }

        return product;
    }

    public boolean ExtendedTrigger(boolean trigger, Product product) {
        if(product.getId() != 0) {
            trigger = !trigger;
        }
        return trigger;
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

    public List<Product> GetAllProducts() {
        return dbcrud.findAll();
    }

    public void DeleteDataById(int id) {
        try {
            dbcrud.deleteById(id);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> DeleteCartItem(ArrayList<Product> cart, int id) {
        for(int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getId() == id) {
                cart.remove(i);
            }
        }
        return cart;
    }

    public void SaveData(Product product) {
        try {
            dbcrud.save(product);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
