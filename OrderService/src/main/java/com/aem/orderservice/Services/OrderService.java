package com.aem.orderservice.Services;

import com.aem.orderservice.Clients.ProductClient;
import com.aem.orderservice.models.Order;
import com.aem.orderservice.repositories.OrderRepository;
import com.aem.productservice.models.Product;
import com.aem.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order addOrder(Order order) {
        Product product = productClient.getProductById(order.getProductId());
        if (product != null) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
