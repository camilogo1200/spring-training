# Description

This example teach you how to create a bean programatically using context.registerBean().

````java
//remove the @Component annotation from class to avoid being created by Spring
public class BeanClass {
  //...
}

//Implement code to create and register the bean a Supplier
Supplier<Bean .class>beanSupplierLambda =()->{
    //creates a bean
    // ...
    return bean;
};

//register the bean using registerBean from context
context.registerBean("beanRegisterName", Bean.class, beanSupplierLambda);

//retrieve the bean from context
try{
  var customerBeanFromContext = context.getBean("beanRegisterName", Bean.class);
} catch (NoSuchBeanDefinitionException ex) {
  //handle Exception
}
````