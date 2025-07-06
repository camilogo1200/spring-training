package org.camilogo1200.beans;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Lazy
public class Property {

  private String name;
  private Currency currency;
  private BigDecimal price;

  @PostConstruct
  public void init() {
    name = "Initial value";
    currency = Currency.getInstance("USD");
    price = new BigDecimal("10000000.00");
    System.out.println("== Property initialized (@Lazy) ==");
  }

  @Override
  public String toString() {
    return "Property{" +
        "name='" + name + '\'' +
        ", currency=" + currency +
        ", price=" + price +
        '}';
  }
}
