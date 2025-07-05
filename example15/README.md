# Description

This example teach you how to test Prototype Bean scope instantiation on beans

1. Spring creates a new bean each and every single time that the bean is required
2. Spring only manages the creation and injection but is not fully managed after creation
    1. Spring does not automatically handle destruction ( calling `@PreDestroy` or `DisposableBean#destroy`)
3. You will need to manage the manual destruction by the client i.e. ( implementing AutoCloseable )
4. Retrieve the bean via ObjectProvider and close manually.
````java

@Component
@Scope("prototype") or @Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CustomerServices {

  private final ObjectProvider<MyPrototypeBean> beanProvider;

  public MyService(ObjectProvider<MyPrototypeBean> beanProvider) {
    this.beanProvider = beanProvider;
  }

  public void process() {
    try (MyPrototypeBean bean = beanProvider.getObject()) {
      bean.doSomething();
    } // Auto-close when exiting scope
  }

}

````