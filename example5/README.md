# Description

This example teach you how @PostConstruct, and @PreDestroy annotation works.

````java
@Component
public class BeanClass{
  //...
  
  //After bean creation spring executes the method marked with @PostConstruct
  @PostConstruct
  public void initialize(){
    // code...
  }
  //...
  
  //Spring will make sure to call this method just before clearing and destroy the context
  @PreDestroy
  private void onDestroy(){
    //code
  }
  
  //...
  
}
````