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
      var customerService = context.getBean(CustomerServices.class);
      var customerService2 = context.getBean("customerServices", CustomerServices.class);

      if (customerService2.hashCode() == customerService.hashCode()) {
        System.out.println("Customer Services are scoped bean to singleton");
      } else {
        System.out.println("Different scopes ( different beans )");
      }

    } catch (NoSuchBeanDefinitionException ex) {
      String message =
          MessageFormat.format("[NoSuchBeanDefinitionException]: {0}",
              ex.getMessage());
      System.out.println(message);
    }

  }
}