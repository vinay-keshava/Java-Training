package org.sample.service;

import org.sample.dao.StudentDao;
import org.sample.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component (value="myService")
public class StudentService {
	@Autowired
	StudentDao sdao;
	
	public Student saveStudent(Student s) {
		return sdao.saveStudent(s);
	}

}
