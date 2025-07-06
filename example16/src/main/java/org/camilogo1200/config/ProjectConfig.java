package org.camilogo1200.config;

import org.camilogo1200.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.camilogo1200")
public class ProjectConfig {

  @Bean
  public Vehicle vehicle() {
    Vehicle vehicle = new Vehicle();
    vehicle.setId("1");
    vehicle.setBrand("Ford");
    vehicle.setModel("2025");
    vehicle.setColor("Diamond Black");
    return vehicle;
  }
}
