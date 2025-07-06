package org.camilogo1200.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
  private String id;
  private String brand;
  private String model;
  private String color;



  @Override
  public String toString() {
    return "Vehicle{" +
        "id='" + id + '\'' +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", color='" + color + '\'' +
        '}';
  }
}
