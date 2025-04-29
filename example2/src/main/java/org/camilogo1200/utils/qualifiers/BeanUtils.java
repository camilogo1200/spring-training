package org.camilogo1200.utils.qualifiers;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.ApplicationContext;

public class BeanUtils {
  public static <T> Collection<T> getBeansByTypeAndAnnotation(
      ApplicationContext applicationContext, Class<T> clazz, Class<? extends Annotation> annotationType
  ) {
    Map<String, T> typedBeans = applicationContext.getBeansOfType(clazz);
    Map<String, Object> annotatedBeans = applicationContext.getBeansWithAnnotation(annotationType);
    typedBeans.keySet().retainAll(annotatedBeans.keySet());
    return typedBeans.values();
  }

  private <T> Optional<T> getBeanByTypeAndAnnotation(
      ApplicationContext applicationContext, Class<T> clazz, Class<? extends Annotation> annotationType
  ) {
    Collection<T> beans = getBeansByTypeAndAnnotation(applicationContext, clazz, annotationType);
    return beans.stream().findFirst();
  }
}
