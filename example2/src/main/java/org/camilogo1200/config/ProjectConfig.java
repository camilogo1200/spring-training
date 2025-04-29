package org.camilogo1200.config;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.utils.qualifiers.EmptyCustomerQualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

  @Bean(name = "DummyCustomer")
  public Customer createDummyCustomer() {
    Customer customer = new Customer();
    customer.setName("XXXXX");
    customer.setLastName("X.XXX");
    customer.setAddress("Av 123 # 123 - 123");
    customer.setPhone("123456789");
    customer.setEmail("myEmail@Myemail.com");
    return customer;
  }

  @Bean(value = "FakeCustomer")
  public Customer createFakeCustomer() {
    Customer customer = new Customer();
    customer.setName("Fake Customer");
    customer.setLastName("X.XXX");
    customer.setAddress("Av 123 # 123 - 123");
    customer.setPhone("123456789");
    customer.setEmail("myFakeEmail@Myemail.com");
    return customer;
  }

  @Bean("EmptyCustomer")
  public Customer createEmptyCustomer() {
    Customer customer = new Customer();
    customer.setName("");
    customer.setLastName("");
    customer.setAddress("");
    customer.setPhone("");
    customer.setEmail("");
    return customer;
  }

  @Bean
  @EmptyCustomerQualifier
  public Customer createEmptyCustomerWithQualifier() {
    Customer customer = new Customer();
    customer.setName("Bean Marked with qualifier");
    customer.setLastName("@EmptyQualifier");
    customer.setAddress("None");
    customer.setPhone("123456789");
    customer.setEmail("emptyQualifier@myemail.com");
    return customer;
  }

}
