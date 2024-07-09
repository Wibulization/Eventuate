package com.example.demo.CustomerEventuate.Event;

import com.example.demo.OrderEventuate.Entity.Money;

public class CustomerCreditReservedEvent implements CustomerEvent {
    private String orderID;
    private Money orderTotal;

    public CustomerCreditReservedEvent(String orderID, Money orderTotal) {
        this.orderID = orderID;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public Money getOrderTotal() {
        return orderTotal;
    }

}
