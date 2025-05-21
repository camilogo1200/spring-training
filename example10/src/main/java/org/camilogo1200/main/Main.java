package org.camilogo1200.main;

import java.text.MessageFormat;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.beans.Property;
import org.camilogo1200.beans.Vehicle;
import org.camilogo1200.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    try {
      var customer = context.getBean(Customer.class);
      var vehicle = context.getBean(Vehicle.class);
      var property = context.getBean(Property.class);

      var customerMessage = MessageFormat.format(" Customer from context = {0}", customer);
      var vehicleMessage = MessageFormat.format(" Vehicle from context= {0} ", vehicle);
      var propertyMessage = MessageFormat.format(" Property from context = {0} ", property);
      var customerWalletMessage =
          MessageFormat.format(" Waller from customer using @Autowired = {0} ", customer.getWallet());
      var customerVehicle = MessageFormat.format(" Customer vehicle  using @Autowired = {0}", customer.getVehicle());
      var customerProperty = MessageFormat.format(" Customer property using @Autowired = {0}", customer.getProperty());

      System.out.println(customerMessage);
      System.out.println(vehicleMessage);
      System.out.println(propertyMessage);
      System.out.println(customerWalletMessage);
      System.out.println(customerVehicle);
      System.out.println(customerProperty);

    } catch (NoSuchBeanDefinitionException ex) {
      String message =
          MessageFormat.format("[NoSuchBeanDefinitionException]: {0}",
              ex.getMessage());
      System.out.println(message);
    }

  }
}