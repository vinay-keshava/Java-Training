package org.sample.spring_core.annotationVariable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="myUser")
public class User {
	@Value (value="980")
	int id;
	
	@Value (value="vinay")
	String name;
	
	public void print() {
		System.out.println(id);
		System.out.println(name);
	}
}
