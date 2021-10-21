package com.grupp3.grupp3mvc.controller;

import com.grupp3.grupp3mvc.CRUDRepository;
import com.grupp3.grupp3mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired //prova sen att ta bort
    CRUDRepository dbcrud; //Skapar ett "abstrakt" objekt, kommer åt funktioner utan att skapa ett faktiskt objekt

    List<Product> products;// VI skapar en lista av array med vår pojo product
    List<Product> cart;// skapar en varukorg

    @RequestMapping("/home")
    public String homepage(Model model) { // Model kopplat till spring funktioner som är kopplad till thymeleaf

        products = dbcrud.findAll(); // hämtar all data från våran tabell

        model.addAttribute("allProducts", products); // Vi skapar en attribut som heter allproducts som pekar mot products
        //som är vår lista med data, med det kan vi använda attributen i thymeleaf


        return "home.html"; // här hamnar vi på html filen
    }


    @RequestMapping("/addtocart")
    public  String addtocart(@RequestParam(value = "id")Integer id) {

        System.out.println(id);

        return "redirect:/home";         // Kastar om efter metoden direkt till home

    }


}