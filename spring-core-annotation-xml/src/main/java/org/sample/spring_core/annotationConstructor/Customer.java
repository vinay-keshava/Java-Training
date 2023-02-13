package org.sample.spring_core.annotationConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component (value="myCustomer")
public class Customer {
int id;
String name;
public Customer(@Value (value="876") int id,@Value(value="Vinay") String name) {
	super();
	this.id = id;
	this.name = name;
}
public void print() {
	System.out.println(id);
	System.out.println(name);
}
}
