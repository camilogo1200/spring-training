# Description

This example teach you how to create a bean form the XML configuration using the file `beans.xml` on the resources
folder
and set a property value using the property tag and value

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