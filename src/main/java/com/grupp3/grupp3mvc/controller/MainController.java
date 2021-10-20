package com.grupp3.grupp3mvc.controller;

import com.grupp3.grupp3mvc.CRUDRepository;
import com.grupp3.grupp3mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CRUDRepository dbcrud; //Skapar ett "abstrakt" objekt, kommer åt funktioner utan att skapa ett faktiskt objekt

    List<Product> products;

    @RequestMapping("/home")
    public String homepage(Model model) {

        products = dbcrud.findAll();

        model.addAttribute("allProducts", products);

        return "home.html";
    }
}
