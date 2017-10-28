package com.desiby.groceryclient.service;

import com.desiby.groceryclient.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//set up the class as a service
@Service
public class RestClientService {

    //define a RestTemplate object
    private final RestTemplate restTemplate;

    //web service resources endpoints
    private final String GET_ALL_URL = "http://localhost:8080/api/all";
    private final String GET_URL_BY_ID = "http://localhost:8080/api/product/";

    //define an argument constructor, pass in the RestTemplate object
    //and Autowire it
    @Autowired
    public RestClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Get all products
     * @return a list
     */
    public List<Product> findAllProducts(){
        return Arrays.stream(restTemplate.getForObject(GET_ALL_URL,Product[].class)).collect(Collectors.toList());
    }

    /**
     * Get a product by id
     * @param id of product
     * @return a product
     */
    public Product findProductById(String id){
        return restTemplate.getForObject(GET_URL_BY_ID +id, Product.class);
    }
}
