# Description

This example teach you how to test eager and lazy instantiation on beans

1. Eager is the default behavior on Spring.
2. `@Lazy` can be user with `@Component` or `@Bean` annotation
3. if @Lazy is not present, the default behavior is eager
4. when is present and set to true the `@Bean` or `@Component` will not be instantiated until referenced by another bean
   or explicitly retrieved form the BeanFactory
5. if `@Lazy` is present in a `@Configuration` class all the bean are initialized in a lazy way.
6. This annotation can be placed on the injection points marked with `@Autowired` or `@Inject`

````java

@Component //By default, is always singleton
@Lazy //initialize the singleton bean only when the application is trying to refer to the bean

@Component
@Lazy
public class Property {

  @PostConstruct
  // in Lazy bean this is only be executed when we need the bean reference 
  // not in the beginning of the startup process
  public void init() {
  }

}

````