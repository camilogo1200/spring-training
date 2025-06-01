# Description

This example teach you how to test the bean scope, the following example demostrate the singleton bean scope.

````java
@Component //By default, is always singleton
@Scope(BeanDefinition.SCOPE_SINGLETON) //you can also specify the scope for the bean using the @Scope annotation
public class CustomerServices {

}
````