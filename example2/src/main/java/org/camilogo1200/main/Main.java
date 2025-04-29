package org.camilogo1200.main;

import java.util.Collection;

import org.camilogo1200.beans.Customer;
import org.camilogo1200.config.ProjectConfig;
import org.camilogo1200.utils.qualifiers.BeanUtils;
import org.camilogo1200.utils.qualifiers.EmptyCustomerQualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {

    //exception .NoUniqueBeanDefinitionException
    //use name, value properties to avoid it!
    //qualifiers is a clean approach but needs more knowledge
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Customer nameOfMethod = context.getBean("nameOfMethodToCreateCustomer", Customer.class);
    System.out.println(nameOfMethod);

    Customer emptyCustomer = context.getBean("EmptyCustomer", Customer.class);
    System.out.println(emptyCustomer);

    Customer dummyCustomer = context.getBean("DummyCustomer", Customer.class);
    System.out.println(dummyCustomer);

    Customer fakeCustomer = context.getBean("FakeCustomer", Customer.class);
    System.out.println(fakeCustomer);

    Collection<Customer> emptyQualifierCustomer =
        BeanUtils.getBeansByTypeAndAnnotation(context, Customer.class, EmptyCustomerQualifier.class);
    System.out.println(emptyQualifierCustomer);

  }
}