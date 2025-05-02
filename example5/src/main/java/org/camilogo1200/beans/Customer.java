package org.camilogo1200.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private int id;
  private String name;
  private String lastName;
  private String address;
  private String phone;
  private String email;

  @PostConstruct
  public void initialize() {
    System.out.println("Initializing Customer with method annotated with @PostConstruct");
    this.name = this.lastName = this.address = this.phone = this.email = "";
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Destroying Customer with method annotated with @PreDestroy");
    this.name = this.lastName = this.address = this.phone = this.email = "";
  }

  public void printCustomer() {
    System.out.println("printCustomer - Customer ID: " + id);
  }
}
