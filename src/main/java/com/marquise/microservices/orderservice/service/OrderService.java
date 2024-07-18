package com.marquise.microservices.orderservice.service;

import com.marquise.microservices.orderservice.dto.OrderRequest;
import com.marquise.microservices.orderservice.model.Order;
import com.marquise.microservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        // map OrderRequest to Order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        // save Order object to orderRepository
        orderRepository.save(order);
    }
}
