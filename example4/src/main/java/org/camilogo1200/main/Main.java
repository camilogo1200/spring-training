package org.camilogo1200.main;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    //avoids exception .NoUniqueBeanDefinitionException using @Primary annotation
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    Customer annotatedComponentBean = context.getBean(Customer.class);
    System.out.println(annotatedComponentBean);
    annotatedComponentBean.printCustomer();
  }
}