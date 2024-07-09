package com.example.demo.OrderEventuate.Event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.example.demo.OrderEventuate.Entity.Money;

public class CreatedOrderEvent implements OrderEvent {
    private Money orderTotal;
    private String customerId;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public CreatedOrderEvent() {
    }

    public CreatedOrderEvent(String customerId, Money orderTotal) {
        this.customerId = customerId;
        this.orderTotal = orderTotal;
    }

    public Money getOrderTotal() {
        return orderTotal;
    }

    public String getCustomerId() {
        return customerId;
    }
}
