package mapping.one.to.one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Person {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
@OneToOne
private Aadhar a;
private String emailId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Aadhar getA() {
	return a;
}
public void setA(Aadhar a) {
	this.a = a;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

	
}
