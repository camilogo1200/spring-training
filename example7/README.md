# Description

This example teach you how to create a bean form the XML configuration using the file `beans.xml` on the resources
folder
and set a property value using the property tag and value

````xml
<!-- beans.xml configuration file on resources folder -->

<?xml version="1.0" encoding="utf-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="bean" class="org.path.bean.package.MyBeanClass">
    <property name="name" value="xml file property tag valuee"/>
  </bean>
</beans>
````