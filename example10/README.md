# Description

This example teach you how to create a bean and inject into a class as a dependency
using the @Autowired annotation on a class field.

Note:

The class that uses the @Autowired should be a component

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
public class Vehicle {
  //...
}

@Component
public class Customer {
  //...
  @Autowired
  private Vehicle vehicle;

}

````

# Note

- in scenarios that the bean is not required, you can remove the exception of using the @Autowiring over a bean that has
  not a provider or is not ready to inject using @Autowired ( required=false)

````java
@Component
public class Customer {
  @Autowired
  private Vehicle vehicle;

  @Autowired(required = false)
  private Wallet wallet;
  //...
}
````