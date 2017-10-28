package com.desiby.groceryclient.controller;

import com.desiby.groceryclient.service.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    //define a service constant
    private final RestClientService service;

    //Argument contructor of controller, pass in the service
    //and Autowire it
    @Autowired
    public ProductController(RestClientService service){
       this.service = service;
    }

    /**
     * Get all products
     * @param model to bind products to view
     * @return the products.html page
     */
    @GetMapping("products")
    public String getAll(Model model){
        model.addAttribute("products", service.findAllProducts());
        return "products";
    }

    /**
     * Get a product by id
     * @param id of product
     * @param model binding a product to view
     * @return a product page
     */
    @RequestMapping("/product/{id}")
    public String getById(@PathVariable String id, Model model){
        model.addAttribute("product", service.findProductById(id));
        return "showproduct";
    }
}
