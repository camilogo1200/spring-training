# Description

This example teach you how to create a dependent bean object, this is done by calling the method
that creates the bean, this method should be annotated with @Bean, and Spring
will be managing the bean lifecycle, creating only one instance.

````java
 public Vehicle vehicle() {
  Vehicle vehicle = new Vehicle();
  //...
  return vehicle;
}

@Bean
public Customer customer() {
  Customer customer = new Customer();
  //...
  // call to the method -> Spring provides if @Bean returning a Vehicle exists
  customer.setVehicle(vehicle());
  return customer;
}

````