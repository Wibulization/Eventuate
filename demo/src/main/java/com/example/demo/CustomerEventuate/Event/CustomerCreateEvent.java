package com.example.demo.CustomerEventuate.Event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.example.demo.OrderEventuate.Entity.Money;

public class CustomerCreateEvent implements CustomerEvent {
    private String name;
    private Money creditLimit;

    public CustomerCreateEvent(String name, Money creditLimit) {
        this.name = name;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getName() {
        return name;
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

}
