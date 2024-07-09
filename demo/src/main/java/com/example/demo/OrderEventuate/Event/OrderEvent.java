package com.example.demo.OrderEventuate.Event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.example.OrderEventuate.Entity.Order")
public interface OrderEvent extends Event {

}
