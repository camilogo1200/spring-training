# Description

This example exemplifies how to retrieve or get a bean from the Container, 
using the context, using @Primary annotation

`````java
//example
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    beanClass bean = context.getBean(beanClass.class);
    System.out.println(bean);
`````

````java
//annotated bean method with @EmptyCustomerQualifier qualifier
@Bean
@Primary
public Customer createBean() {
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