package SetterInjection;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TeacherController {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac= new ClassPathXmlApplicationContext("setterInjection.xml");
		Teacher teacherOfAiet=(Teacher) ac.getBean("t1");
//		teacherOfAiet.name
		System.out.println(teacherOfAiet.name);
		
	}

}
