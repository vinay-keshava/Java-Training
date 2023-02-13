package org.sample.aadhar;

import java.util.Scanner;

public class PersonController {
	static Person person = new Person();
	static Aadhar adhar = new Aadhar();
	static PersonDao dao = new PersonDao();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1.SavePersonAdhar\t2.Delete by id");
			System.out.println("Choose your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				adhar.setAdhaarNumber(23456789);
				adhar.setAddress("Bengaluru");

				person.setName("Abhi");
				person.setEmail("abhi@gmail.com");
				person.setAdhar(adhar);
				dao.savePerson(person, adhar);
			}
				break;
			case 2:{
				int id=scanner.nextInt();
				dao.deleteById(id);
			}
			break;
			
			case 3:{
				
			}break;
			}
		}
	}

}
