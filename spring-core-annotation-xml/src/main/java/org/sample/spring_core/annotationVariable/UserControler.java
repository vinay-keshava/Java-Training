package org.sample.spring_core.annotationVariable;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControler {

	public static void main(String[] args) {
			ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("annotation.xml");
			User vinay=(User)cac.getBean("myUser");
			vinay.print();
	}

}
