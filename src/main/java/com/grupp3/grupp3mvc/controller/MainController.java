package com.grupp3.grupp3mvc.controller;

import com.grupp3.grupp3mvc.CRUDRepository;
import com.grupp3.grupp3mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
// test
@Controller
public class MainController {

    @Autowired //prova sen att ta bort
    CRUDRepository dbcrud; //Skapar ett "abstrakt" objekt, kommer åt funktioner utan att skapa ett faktiskt objekt

    List<Product> products;// VI skapar en lista av array med vår pojo product
    Product tempProduct;
    ArrayList<Product> cart = new ArrayList<>();//skapar en varukorg
    boolean popupTrigger = false;
    boolean productformtrigger = false;

    @RequestMapping("/home")
    public String homepage(Model model) { // Model kopplat till spring funktioner som är kopplad till thymeleaf

            model.addAttribute("numOfItems", cart.size());

        return "home.html"; // här hamnar vi på html filen
    }

    @RequestMapping("/addtocart")
    public  String addtocart(@RequestParam(value = "id") Integer id) {

            cart.add(dbcrud.findById(id).get());

        return "redirect:/products";         // Kastar om efter metoden direkt till home
    }

    @RequestMapping("/admin")
    public String adminPage(Model model) {

        products = dbcrud.findAll();

        if(tempProduct != null) {
            model.addAttribute("product", tempProduct);
        }

        model.addAttribute("trigger",popupTrigger);
        model.addAttribute("products", products);
        model.addAttribute("numOfItems", cart.size());

        return "admin.html";
    }

    @RequestMapping("/cart")
    public String displayCart(Model model) {

            model.addAttribute("cartItems",cart);
            model.addAttribute("numOfItems", cart.size());

        return "cart.html";
    }

    @RequestMapping("/products")
    public String products(Model model) {

            products = dbcrud.findAll(); // hämtar all data från våran tabell
            model.addAttribute("allProducts",products);
            //model.addAttribute("allProducts", products); // Vi skapar en attribut som heter allproducts som pekar mot products
            //som är vår lista med data, med det kan vi använda attributen i thymeleaf
            model.addAttribute("numOfItems", cart.size());

        return "products.html";
    }


    @RequestMapping("/deleteItem")
    public String deleteItem(@RequestParam(value = "id") Integer id) {

            for(int i = 0; i < cart.size(); i++) {
                if(cart.get(i).getId() == id) {
                    cart.remove(i);
                }
            }

            return "redirect:/cart";
    }

    @RequestMapping("/edit")
    public String editProductPopopUp(@RequestParam(value = "id") int id) {

        tempProduct = dbcrud.findById(id).get();
        popupTrigger = true;

        System.out.println(tempProduct);

        return "redirect:/admin";
    }

    @RequestMapping("/deleteData")
    public String deleteDataobject(@RequestParam(value = "id") int id) {
        dbcrud.deleteById(id);

        return "redirect:/admin";
    }
    @RequestMapping("/newproduct")
    public String newproduct(Model model) {
        productformtrigger = true;
        Product newproduct = new Product();
        model.addAttribute("product",newproduct);
        return "redirect:/admin";

    }

    @RequestMapping("/saveData")
    public String saveDataobject(@ModelAttribute Product product) {
          //dbcrud.save(product);
        System.out.println(product);

        return "redirect:/admin";
    }

    @RequestMapping("/goback")
    public String goback() {

        popupTrigger = false;

        return "redirect:/admin";
    }
}
