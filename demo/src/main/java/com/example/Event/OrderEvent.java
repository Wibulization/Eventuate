package com.example.Event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.example.Entity.Order")
public interface OrderEvent extends Event {

}
