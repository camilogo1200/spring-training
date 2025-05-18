package org.camilogo1200.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
  private int id;
  private String name;
  private String lastName;
  private String address;
  private String phone;
  private String email;

  @Autowired
  private Property property;
  @Autowired
  private Vehicle vehicle;

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +  '\n' +
        ", property=" + property + '\n' +
        ", vehicle=" + vehicle + '\n' +
        '}';
  }
}
