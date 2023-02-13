package org.sample.spring_core.annotationReference;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollegeController {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("annotation.xml");
		College c=(College)cac.getBean("aiet");
		c.getCollege();
	}

}
