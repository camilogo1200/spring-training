package org.camilogo1200.services;

import java.util.Random;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Component //By default, is always singleton
@Scope(BeanDefinition.SCOPE_PROTOTYPE) //you can also specify the scope for the bean using the @Scope annotation
//@Scope("prototype")
public class CustomerServices implements AutoCloseable {

  private final ObjectProvider<LogService> logServiceProvider;

  public CustomerServices(ObjectProvider<LogService> logServiceProvider) {
    this.logServiceProvider = logServiceProvider;
  }

  @Getter
  public int number = 0;

  @PostConstruct
  private void init() {
    Random rand = new Random();
    this.number = rand.nextInt(99999);
    System.out.println("==== INIT METHOD ON CUSTOMER SERVICES ====");
    logServiceProvider.stream().forEach(lsp -> lsp.log("== Init number => " + number + " =="));
    System.out.println("==== END INIT METHOD ON CUSTOMER SERVICES ====");
  }

  @Override
  public void close() {
    System.out.println(
        "Cleaning up resources for CustomerServices bean. number = [" + getNumber() + "] - close() method");
  }
}
