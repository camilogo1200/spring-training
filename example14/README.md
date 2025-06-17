# Description

This example teach you how to test eager and lazy instantiation on beans
````java
@Component //By default, is always singleton
@Lazy //initialize the singletong bean only when the application is trying to refer to the bean
public class CustomerServices {

}
````