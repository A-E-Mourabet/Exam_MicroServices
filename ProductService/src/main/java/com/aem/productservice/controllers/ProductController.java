package com.aem.productservice.controllers;

import com.aem.productservice.Services.KafkaProducer;
import com.aem.productservice.Services.ProductService;
import com.aem.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/topic")
    public String topicMessage(){
        KafkaProducer producer = new KafkaProducer();
        producer.sendMessage("test message");
        return "tested";
    }
}
