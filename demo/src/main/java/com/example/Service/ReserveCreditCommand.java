package com.example.Service;

import com.example.Entity.Money;

public class ReserveCreditCommand implements CustomerCommand {
  private final Money orderTotal;
  private final String orderId;

  public ReserveCreditCommand(Money orderTotal, String orderId) {
    this.orderTotal = orderTotal;
    this.orderId = orderId;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public String getOrderId() {
    return orderId;
  }
}
