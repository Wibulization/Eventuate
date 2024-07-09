package com.example.demo.OrderEventuate.Entity;

import java.util.List;

import com.example.demo.OrderEventuate.Event.ApprovedOrderEvent;
import com.example.demo.OrderEventuate.Event.CreatedOrderEvent;
import com.example.demo.OrderEventuate.Event.RejectedOrderEvent;
import com.example.demo.OrderEventuate.Service.ApproveOrderCommand;
import com.example.demo.OrderEventuate.Service.CreateOrderCommand;
import com.example.demo.OrderEventuate.Service.OrderCommand;
import com.example.demo.OrderEventuate.Service.RejectOrderCommand;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class Order extends ReflectiveMutableCommandProcessingAggregate<Order, OrderCommand> {
    private OrderState state;
    private String customerId;

    public OrderState getState() {
        return state;
    }

    public List<Event> process(CreateOrderCommand cmd) {
        return EventUtil.events(new CreatedOrderEvent(cmd.getCustomerId(), cmd.getOrderTotal()));
    }

    public List<Event> process(ApproveOrderCommand cmd) {
        return EventUtil.events(new ApprovedOrderEvent(customerId));
    }

    public List<Event> process(RejectOrderCommand cmd) {
        return EventUtil.events(new RejectedOrderEvent(customerId));
    }

    public void apply(CreatedOrderEvent event) {
        this.state = OrderState.CREATED;
        this.customerId = event.getCustomerId();
    }

    public void apply(ApprovedOrderEvent event) {
        this.state = OrderState.APPROVED;
    }

    public void apply(RejectedOrderEvent event) {
        this.state = OrderState.REJECTED;
    }
}
