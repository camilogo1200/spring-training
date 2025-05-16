package org.camilogo1200.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private Vehicle vehicle;

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", vehicle=" + vehicle +
        '}';
  }
}
