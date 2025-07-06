package org.camilogo1200.main;

import java.text.MessageFormat;

import org.camilogo1200.config.ProjectConfig;
import org.camilogo1200.services.CustomerServices;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    try {
      try (var customerServices = context.getBean(CustomerServices.class);
          var customerServices2 = context.getBean("customerServices", CustomerServices.class)) {
        System.out.println(customerServices.getNumber());
        System.out.println(customerServices2.getNumber());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      var customerServices3 = context.getBean(CustomerServices.class);
      System.out.println(customerServices3.getNumber());
      //CustomerServices3 does not call the close method on the autocloseable interface
    } catch (NoSuchBeanDefinitionException ex) {
      String message =
          MessageFormat.format("[NoSuchBeanDefinitionException]: {0}",
              ex.getMessage());
      System.out.println(message);
    }

  }
}