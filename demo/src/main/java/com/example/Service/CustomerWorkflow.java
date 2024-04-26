package com.example.Service;

import java.util.concurrent.CompletableFuture;

import com.example.Entity.Customer;
import com.example.Entity.Money;
import com.example.Event.CreatedOrderEvent;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "customerworkflow")
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
