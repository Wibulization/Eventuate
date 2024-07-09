package com.example.demo.CustomerEventuate.Service;

import com.example.demo.OrderEventuate.Entity.Money;

public class CreateCustomerCommand implements CustomerCommand {
    private String name;
    private Money creditLimit;

    public CreateCustomerCommand(String name, Money creditLimit) {
        this.name = name;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public Money getCreditLimit() {
        return creditLimit;
    }

}
