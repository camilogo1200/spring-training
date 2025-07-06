# Description

This example teach you how to use `ObjectProvider` with bean resolution

1. This is an extension of the `Objectfactory`.
2. Contains handy signatures such as `getIfAvailable` `getIfUnique`,etc..., to retrieve a bean only if it actually exists.
3. Improve the programmatic resolution of dependencies.

````java

@Component
@Scope("prototype")or@Scope(BeanDefinition.SCOPE_PROTOTYPE)

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