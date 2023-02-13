package beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac=new  ClassPathXmlApplicationContext("beans.xml");
		SingletonHello sh=(SingletonHello)ac.getBean("singletonHello");
		sh.setMessage("Hello From Main singletonHello bean id");
		System.out.println(sh.getMessage());
		
		SingletonHello shh=(SingletonHello)ac.getBean("singletonHello");
		shh.getMessage();
	}
	
}

