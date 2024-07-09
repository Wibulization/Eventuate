package com.example.demo.CustomerEventuate.Service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.CustomerEventuate.Entity.Customer;
import com.example.demo.OrderEventuate.Entity.Money;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public class CustomerServiceImpl implements CustomerService {
    private final AggregateRepository<Customer, CustomerCommand> customerRepository;

    public CustomerServiceImpl(AggregateRepository<Customer, CustomerCommand> customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Customer>> createCustomer(String name, Money creditLimit) {
        return customerRepository.save(new CreateCustomerCommand(name, creditLimit));
    }

    @Override
    public CompletableFuture<EntityWithMetadata<Customer>> findbyID(String customerID) {
        return customerRepository.find(customerID);
    }

}
