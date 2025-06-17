package org.camilogo1200.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //By default, is always singleton
@Scope(BeanDefinition.SCOPE_SINGLETON) //you can also specify the scope for the bean using the @Scope annotation
public class CustomerServices {

}
