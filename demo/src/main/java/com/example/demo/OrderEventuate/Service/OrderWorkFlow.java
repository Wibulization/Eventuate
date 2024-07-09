package com.example.demo.OrderEventuate.Service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.CustomerEventuate.Event.CustomerCreditLimitExceededEvent;
import com.example.demo.CustomerEventuate.Event.CustomerCreditReservedEvent;
import com.example.demo.OrderEventuate.Entity.Order;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EventHandlerContext;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;

@EventSubscriber(id = "orderWorkflow")
public class OrderWorkFlow {
    @EventHandlerMethod
    public CompletableFuture<EntityWithIdAndVersion<Order>> creditLimitReserved(
            EventHandlerContext<CustomerCreditReservedEvent> ctx) {
        String orderId = ctx.getEvent().getOrderID();

        return ctx.update(Order.class, orderId, new ApproveOrderCommand());
    }

    @EventHandlerMethod
    public CompletableFuture<EntityWithIdAndVersion<Order>> creditLimitExceeded(
            EventHandlerContext<CustomerCreditLimitExceededEvent> ctx) {
        String orderId = ctx.getEvent().getOrderID();

        return ctx.update(Order.class, orderId, new RejectOrderCommand());
    }

}
