package com.example.demo.CustomerEventuate.Service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.OrderEventuate.Entity.Money;

public class ReversedCreditTracker {
    private Map<String, Money> creditReservations = new HashMap<>();

    public Money reservedCredit() {
        return creditReservations.values().stream().reduce(Money.ZERO, Money::add);
    }

    public void addReservation(String orderId, Money orderTotal) {
        creditReservations.put(orderId, orderTotal);
    }
}
