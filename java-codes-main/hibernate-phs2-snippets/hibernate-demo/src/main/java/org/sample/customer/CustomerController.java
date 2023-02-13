package org.sample.customer;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Customer c;
		CustomerDao cdao = new CustomerDao();
		while (true) {
			System.out.println("1.Save Customer \t 2.Update Customer");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				c = new Customer();
				System.out.println("Enter the customerName");
				c.setName(scanner.next());
				System.out.println("Enter the CustomerEmail");
				c.setEmail(scanner.next());
				cdao.saveCustomer(c);
			}
				break;
			case 2:{
					c=new Customer();
					System.out.println("Enter cust id");
					int id=scanner.nextInt();
					System.out.println("Enter new cust name");
					String nam=scanner.next();
					System.out.println("Enter new cust email");
					String email=scanner.next();
					Customer c1=cdao.updateById(id,nam,email);
					System.out.println(c1.getId()+""+c1.getEmail()+""+c1.getName());
			}
			break;
			case 3:{
				c=new Customer();
				System.out.println("Enter cust id");
				int id=scanner.nextInt();
				Customer c1=cdao.deleteById(id);
				System.out.println(c1.getId()+""+c1.getEmail()+""+c1.getName());
		}
		break;
			case 4:
				List<Customer> l1=cdao.displayAll();
				for(Customer cust:l1)
					System.out.println(cust.getEmail()+""+cust.getName()+""+cust.getId());
				}
				
				break;
		}

	}


}