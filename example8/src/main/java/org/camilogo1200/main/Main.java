package org.camilogo1200.main;

import java.text.MessageFormat;

import org.camilogo1200.beans.Customer;
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

      var customerMessage = MessageFormat.format(" Customer = {0}", customer);
      var vehicleMessage = MessageFormat.format(" Vehicle = {0} ", vehicle);
      var customerVehicle = MessageFormat.format(" Customer vehicle = {0}", customer.getVehicle());

      System.out.println(customerMessage);
      System.out.println(vehicleMessage);
      System.out.println(customerVehicle);

    } catch (NoSuchBeanDefinitionException ex) {
      String message =
          MessageFormat.format("Customer or Vehicle bean does not exist [NoSuchBeanDefinitionException]: {0}",
              ex.getMessage());
      System.out.println(message);
    }

  }
}