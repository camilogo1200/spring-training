package org.camilogo1200.main;

import java.text.MessageFormat;
import java.util.function.Supplier;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    //creates a Supplier using lambda expresions and functional interfaces
    Supplier<Customer> brianCustomerSupplier = () -> {
      //creates a bean
      var customer = new Customer(0, "Brian", "Thomson", "Av. evergreen 123", "+1 30525689", "brian@aol.com");
      return customer;
    };
    context.registerBean("brianCustomer", Customer.class, brianCustomerSupplier);

    Customer customerBeanFromContext = null;

    try {
      customerBeanFromContext = context.getBean("brianCustomer", Customer.class);
      System.out.println(customerBeanFromContext.toString());
    } catch (NoSuchBeanDefinitionException ex) {
      String message = MessageFormat.format("Customer bean does not exist: {0}", ex.getMessage());
      System.out.println(message);
    }

  }
}