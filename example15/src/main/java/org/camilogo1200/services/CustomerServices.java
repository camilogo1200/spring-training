package org.camilogo1200.services;

import java.util.Random;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component //By default, is always singleton
@Scope(BeanDefinition.SCOPE_PROTOTYPE) //you can also specify the scope for the bean using the @Scope annotation
//@Scope("prototype")
public class CustomerServices implements AutoCloseable {

  public int number = 0;

  @PostConstruct
  private void init() {
    Random rand = new Random();
    this.number = rand.nextInt(99999);
    System.out.println("== Init number => " + number + " ==");
  }

  public int getNumber() {
    return number;
  }

  @Override
  public void close() throws Exception {
    System.out.println("Cleaning up resources for CustomerServices bean. - close() method");
  }
}
