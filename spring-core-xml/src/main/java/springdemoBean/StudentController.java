package springdemoBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class StudentController {

	
	public static void main(String[] args) {
		BeanFactory beanfac=new ClassPathXmlApplicationContext("student.xml");
		Student s=beanfac.getBean("stud1",Student.class);
		s.getStudent();
		
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("student.xml");
		Student s1=ac.getBean("stud2",Student.class);
		
		
	}

}
