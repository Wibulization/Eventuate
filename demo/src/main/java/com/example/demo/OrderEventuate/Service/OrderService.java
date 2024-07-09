package com.example.demo.OrderEventuate.Service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.OrderEventuate.Entity.Money;
import com.example.demo.OrderEventuate.Entity.Order;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

public class OrderService {
    private final AggregateRepository<Order, OrderCommand> orderRepository;

    public OrderService(AggregateRepository<Order, OrderCommand> orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CompletableFuture<EntityWithIdAndVersion<Order>> createOrder(String IDcustomer, Money total) {
        return orderRepository.save(new CreateOrderCommand(IDcustomer, total));
    }
}
