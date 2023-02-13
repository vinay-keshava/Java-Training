package mapwithanno;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {

	public static void main(String[] args) {
		while (true) {
			System.out.println("1.Insert \t2.Update\t3.Delete\t4.PrintEnter the choice:");
			Scanner s = new Scanner(System.in);
			EmployeeDao edao = new EmployeeDao();
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				String fn, ln;
				Employee e = new Employee();
				e.setFirstName(s.next());
				e.setLastName(s.next());
				edao.saveEmployee(e);

			}
				break;
			case 2:{
				edao.getEmployeeDetails();
				List<Employee> el=edao.getEmployeeDetails();
				Iterator< Employee> it = el.iterator();
				while(it.hasNext()){
					Employee tmp=it.next();
					System.out.println(tmp.getFirstName()+""+tmp.getLastName()+"");
			}}
				break;
			case 3:
				int id=s.nextInt();
				String newfn=s.next();
				String newln=s.next();
				edao.updateEmployee(id, newfn, newln);
				break;
			case 4:
				int idd=s.nextInt();
				edao.deleteEmployeeById(idd);
				break;
			}
		}
	}

}
