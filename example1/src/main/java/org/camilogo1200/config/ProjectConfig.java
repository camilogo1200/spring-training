package org.camilogo1200.config;

import org.camilogo1200.beans.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Bean
  public Customer createCustomer1() {
    Customer customer1 = new Customer();
    customer1.setName("Cristhian");
    customer1.setLastName("G.");
    customer1.setAddress("Av 123 # 123 - 123");
    customer1.setPhone("123456789");
    customer1.setEmail("myEmail@Myemail.com");
    return customer1;
  }

}
