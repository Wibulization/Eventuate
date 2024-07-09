package com.example.demo.CustomerEventuate.Entity;

import java.util.List;

import com.example.demo.CustomerEventuate.Event.CustomerCreateEvent;
import com.example.demo.CustomerEventuate.Event.CustomerCreditLimitExceededEvent;
import com.example.demo.CustomerEventuate.Event.CustomerCreditReservedEvent;
import com.example.demo.CustomerEventuate.Service.CreateCustomerCommand;
import com.example.demo.CustomerEventuate.Service.CustomerCommand;
import com.example.demo.CustomerEventuate.Service.ReserveCreditCommand;
import com.example.demo.CustomerEventuate.Service.ReversedCreditTracker;
import com.example.demo.OrderEventuate.Entity.Money;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class Customer extends ReflectiveMutableCommandProcessingAggregate<Customer, CustomerCommand> {
    private ReversedCreditTracker reservedCreditTracker;

    private Money creditLimit;
    private String name;

    public Money availableCredit() {
        return creditLimit.subtract(reservedCreditTracker.reservedCredit());
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public List<Event> process(CreateCustomerCommand cmd) {
        return EventUtil.events(new CustomerCreateEvent(cmd.getName(), cmd.getCreditLimit()));
    }

    public List<Event> process(ReserveCreditCommand cmd) {
        if (availableCredit().isGreaterThanOrEqual(cmd.getOrderTotal()))
            return EventUtil.events(new CustomerCreditReservedEvent(cmd.getOrderId(), cmd.getOrderTotal()));
        else
            return EventUtil.events(new CustomerCreditLimitExceededEvent(cmd.getOrderId()));
    }

    public void apply(CustomerCreateEvent event) {
        this.name = name;
        this.creditLimit = event.getCreditLimit();
        this.reservedCreditTracker = new ReversedCreditTracker();
    }

    public void apply(CustomerCreditReservedEvent event) {
        reservedCreditTracker.addReservation(event.getOrderID(), event.getOrderTotal());
    }

    public void apply(CustomerCreditLimitExceededEvent event) {
        // Do nothing
    }

    public String getName() {
        return name;
    }
}
