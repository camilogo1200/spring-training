# Description

This example teach you how to create a dependent bean object,
and adding the dependency as a parameter for the @Bean method.

Note:

- the parameter should be a object type, that Spring has a reference for a method to create, using the @Bean annotation.

````java
 public Vehicle vehicle() {
  Vehicle vehicle = new Vehicle();
  //...
  return vehicle;
}

@Bean
public Customer customer(Vehicle vehicle) {
  Customer customer = new Customer();
  //...
  customer.setVehicle(vehicle);
  return customer;
}

````