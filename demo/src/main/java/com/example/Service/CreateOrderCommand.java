package com.example.Service;

import com.example.Entity.Money;

public class CreateOrderCommand implements OrderCommand {
    private final String customerId;
    private final Money orderTotal;

    public CreateOrderCommand(String customerId, Money orderTotal) {
        this.customerId = customerId;
        this.orderTotal = orderTotal;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Money getOrderTotal() {
        return orderTotal;
    }
}
