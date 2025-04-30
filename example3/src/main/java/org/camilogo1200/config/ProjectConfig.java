package org.camilogo1200.config;

import org.camilogo1200.beans.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

  @Bean
  public Customer nameOfMethodToCreateCustomer() {
    Customer customer = new Customer();
    customer.setName("Customer using name of method");
    customer.setLastName("method Name");
    customer.setAddress("MN 123 # 123 - 123");
    customer.setPhone("123456789");
    customer.setEmail("customerMethodName@Myemail.com");
    return customer;
  }

  @Bean
  @Primary
  public Customer sameSignatureBeanMethodForContainerMatch() {
    Customer customer = new Customer();
    customer.setName("Bean with same signature match but marked as @Primary ");
    customer.setLastName("method Name");
    customer.setAddress("MN 123 # 123 - 123");
    customer.setPhone("123456789");
    customer.setEmail("sameSignatureMethodPrimaryBean@Myemail.com");
    return customer;
  }
}
