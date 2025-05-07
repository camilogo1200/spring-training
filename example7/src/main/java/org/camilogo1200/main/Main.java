package org.camilogo1200.main;

import java.text.MessageFormat;

import org.camilogo1200.beans.Customer;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new ClassPathXmlApplicationContext("beans.xml");

    try {
      var customerBeanFromXmlContext = context.getBean(Customer.class);
      System.out.println(customerBeanFromXmlContext);
    } catch (NoSuchBeanDefinitionException ex) {
      String message = MessageFormat.format("Customer bean does not exist: {0}", ex.getMessage());
      System.out.println(message);
    }

  }
}