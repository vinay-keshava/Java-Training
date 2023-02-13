package org.sample.spring_core.annotationConstructor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerTest {
public static void main(String[] args) {
	ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("annotation.xml");
	Customer c=(Customer)cac.getBean("myCustomer");
	c.print();
}
}
