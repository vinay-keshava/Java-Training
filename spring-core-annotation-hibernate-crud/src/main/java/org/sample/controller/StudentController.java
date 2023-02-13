package org.sample.controller;

import org.sample.MyConfig;
import org.sample.dto.Student;
import org.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class StudentController {


public static void main(String[] args) {
	
	ApplicationContext ac=new AnnotationConfigApplicationContext(MyConfig.class);
	StudentService ss=(StudentService)ac.getBean("myService");
	Student student =(Student)ac.getBean("myStudent");
	student.setId(100);
	student.setName("Vinay");
	student.setEmail("mail@vinaykeshava.in");
	ss.saveStudent(student);
}
}
