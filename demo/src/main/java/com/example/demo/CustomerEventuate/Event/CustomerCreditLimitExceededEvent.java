package com.example.demo.CustomerEventuate.Event;

public class CustomerCreditLimitExceededEvent implements CustomerEvent {
    private String orderID;

    public CustomerCreditLimitExceededEvent(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }
}
