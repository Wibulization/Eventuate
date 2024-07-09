package com.example.demo.CustomerEventuate.Service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.CustomerEventuate.Entity.Customer;
import com.example.demo.OrderEventuate.Entity.Money;

import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public interface CustomerService {
    CompletableFuture<EntityWithIdAndVersion<Customer>> createCustomer(String name, Money creditLimit);

    CompletableFuture<EntityWithMetadata<Customer>> findbyID(String customerID);
}
