package com.aem.orderservice.Clients;

import com.aem.productservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "ProductService")
public interface ProductClient {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable String id);
}
