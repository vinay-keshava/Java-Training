package mapping.one.to.one;

import java.util.Scanner;

public class Controller {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	boolean exit=true;
	Dao dao=new Dao();
	while(exit) {
		System.out.println("1.Insert\n2.Update.\n3.Delete,\n4.Display\nSelect Your Choice\n");
		int choice =s.nextInt();
		switch (choice) {
		case 1:{
		Aadhar a=new Aadhar();
		System.out.println("1.Aadhar addr \t Name");
		a.setAddress(s.next());
		a.setName(s.next());
		Person p=new Person();
		System.out.println("Person");
		p.setEmailId(s.next());
		p.setA(a);
		dao.insertPerson(a, p);
		}break;
		case 2:{
			System.out.println("Enter id to search and the updated email to be updated");
			int tmpid=s.nextInt();
			String email =s.next();
			dao.update(tmpid, email);
		}break;

		case 3:{
			int tmpid=s.nextInt();
			dao.delete(tmpid);
		}break;
		case 4:{
			int dispId=s.nextInt();
			dao.display(dispId);

		}break;
		case 5: exit=false; break;
		}
	}
}
}
