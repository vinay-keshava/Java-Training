package org.sample.Demo;

import org.sample.MyConfigAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BikeController {

	public static void main(String[] args) {
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(MyConfigAnnotation.class);
		Bike royalEnfield=(Bike)ac.getBean("myBike");
		royalEnfield.getBike();
	}

}
