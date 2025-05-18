# Description

This example teach you how to create a bean and inject into a class as a dependency 
using the @Autowired annotation on a class field.

Note:

- the class that uses the @Autowired

````java
//method using @Bean
@Bean
 public Vehicle vehicle() {
  Vehicle vehicle = new Vehicle();
  //...
  return vehicle;
}
// Or class declared with @Component
@Component
public class Vehicle{
  //...
}


@Component
public class Customer {
   //...
  @Autowired
  private Vehicle vehicle;
  
}

````