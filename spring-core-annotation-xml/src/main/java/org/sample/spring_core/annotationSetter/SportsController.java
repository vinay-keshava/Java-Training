package org.sample.spring_core.annotationSetter;

import org.sample.spring_core.annotationConstructor.Customer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SportsController {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("annotation.xml");
		Sports newSport= (Sports)cac.getBean("football");
		System.out.println(newSport.getName());
	}

}
