# Description

This example teach you how to create and retrieve a bean from the Container, 
using the @Component annotation on the bean class

`````java
//example
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    beanClass bean = context.getBean(beanClass.class);
    System.out.println(bean);
`````

````java
//annotated bean method with @Component qualifier
@Component
public class Customer  {
  //...
}

// You need to annotate the config class to @ComponentScan, 
// and you should or must provide a value for the basePackages attribute on the annotation.
// So Spring can scan on that particular package or packages for beans to discover.

Configuration
@ComponentScan(basePackages = "org.camilogo1200")
public class ProjectConfig {}

//get the bean
void anyMethod() {
  // ...
  
  var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
  Customer annotatedBean = context.getBean(Customer.class);
  System.out.println(nameOfMethod);
  
  // ...
}
````