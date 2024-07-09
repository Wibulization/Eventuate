package com.example.demo.CustomerEventuate.Event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.example.CustomerEventuate.Entity.Order")
public interface CustomerEvent extends Event {

}
