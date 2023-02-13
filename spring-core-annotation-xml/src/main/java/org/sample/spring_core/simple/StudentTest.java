package org.sample.spring_core.simple;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("annotation.xml");
		Student s=(Student)cac.getBean("student");
		s.getStudent();
	}

}
