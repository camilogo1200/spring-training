# Description

This sample exemplifies how to retrieve or get a bean from the Container, 
using the context, using different techniques:

- Retrieving using the name of the method in the `context.getBean("<method name String>", beanClass.class)` method from context
- Retrieving using the `@Bean(name="designatedBeanName")` property on the bean
- Retrieving using the `@Bean(value="designatedBeanName")` property on the bean
- Retrieving using the `@Bean("designatedBeanName")` property on the bean
- Retrieving using a Qualifier `@Bean @QualifierExample` annotation on the bean


`````java
//example
var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    Customer nameOfMethod = context.getBean("nameOfMethodToCreateCustomer", Customer.class);
    System.out.println(nameOfMethod);
`````

````java
//annotated bean method with @EmptyCustomerQualifier qualifier
@Bean
@EmptyCustomerQualifier
public Customer createEmptyCustomerWithQualifier() {
  //...
}

//Using @EmptyCustomerQualifier qualifier, with a Utils class to retrieve based on the annotation
Collection<Customer> emptyQualifierCustomer =
    BeanUtils.getBeansByTypeAndAnnotation(context, Customer.class, EmptyCustomerQualifier.class);
    System.out.println(emptyQualifierCustomer);

//Util method to retrieve based on a qualifier annotation
public static <T> Collection<T> getBeansByTypeAndAnnotation(
    ApplicationContext applicationContext, Class<T> clazz, Class<? extends Annotation> annotationType
) {
  Map<String, T> typedBeans = applicationContext.getBeansOfType(clazz);
  Map<String, Object> annotatedBeans = applicationContext.getBeansWithAnnotation(annotationType);
  typedBeans.keySet().retainAll(annotatedBeans.keySet());
  return typedBeans.values();
}
````