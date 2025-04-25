package org.camilogo1200.main;

import java.util.Arrays;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    context.getBeanFactory().getBeanNamesIterator().forEachRemaining(System.out::println);
    Arrays.stream(context.getBeanDefinitionNames()).toList().forEach(System.out::println);

    Customer customer = context.getBean(Customer.class);
    System.out.println(customer.toString());

  }
}