package beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2Prototype {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("/beanScopePrototype.xml");
		PrototypeHello hp1= (PrototypeHello)ac.getBean("prototpyeHello");
		hp1.setMessage("Hello call 1");
		System.out.println(hp1.getMessage());
		
		PrototypeHello hp2=(PrototypeHello)ac.getBean("prototpyeHello");
//		hp2.setMessage("From Obj 2");
		System.out.println(hp2.getMessage());
	}
}
