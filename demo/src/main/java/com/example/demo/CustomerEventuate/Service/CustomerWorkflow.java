package com.example.demo.CustomerEventuate.Service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.CustomerEventuate.Entity.Customer;
import com.example.demo.OrderEventuate.Entity.Money;
import com.example.demo.OrderEventuate.Event.CreatedOrderEvent;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "customerWorkflow")
public class CustomerWorkflow {

    @EventHandlerMethod
    public CompletableFuture<EntityWithIdAndVersion<Customer>> reserveCredit(
            EventHandlerContext<CreatedOrderEvent> ctx) {
        CreatedOrderEvent event = ctx.getEvent();
        Money orderTotal = event.getOrderTotal();
        String customerId = event.getCustomerId();
        String orderId = ctx.getEntityId();

        return ctx.update(Customer.class, customerId, new ReserveCreditCommand(orderTotal, orderId));
    }
}
