package org.camilogo1200.main;

import java.text.MessageFormat;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.beans.Property;
import org.camilogo1200.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    try {
      System.out.println("main init");
      var Customer = context.getBean(Customer.class);
      System.out.println("obtained Customer");
      var property = context.getBean(Property.class);
      System.out.println("obtained property");
      System.out.println(Customer.getAddress());
      System.out.println(property);

    } catch (NoSuchBeanDefinitionException ex) {
      String message =
          MessageFormat.format("[NoSuchBeanDefinitionException]: {0}",
              ex.getMessage());
      System.out.println(message);
    }

  }
}