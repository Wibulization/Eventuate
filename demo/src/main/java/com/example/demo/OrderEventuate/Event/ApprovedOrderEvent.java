package com.example.demo.OrderEventuate.Event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ApprovedOrderEvent implements OrderEvent {
    private String customerId;

    private ApprovedOrderEvent() {
    }

    public ApprovedOrderEvent(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getCustomerId() {
        return customerId;
    }
}
