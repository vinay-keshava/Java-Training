package mapping.one.to.many;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpController {
	public static void main(String[] args) {
		boolean exit = true;
		EmpDao eDao = new EmpDao();
		Scanner s = new Scanner(System.in);
		while (exit) {
			System.out.println("1.Insert");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				Employee e = new Employee();
				int noOfacc = s.nextInt();
				List<BankAcc> list = new ArrayList<BankAcc>();
				for (int i = 0; i < noOfacc; i++) {
					BankAcc b = new BankAcc();
					System.out.println(i + 1 + "Enter bank account type and bank name");
					b.setAccType(s.next());
					b.setBankName(s.next());
					list.add(b);
				}
				e.setAcc(list);
				System.out.println("Enter name and age of Employee");
				e.setAge(s.nextInt());
				e.setEmpName(s.next());
				eDao.insertData(e, list);
			}
				break;
			case 2: {
//				public void update(int id,String name,int age,String bankType) {
				System.out.println("Update Operation\t int id,String name,int age,String bankType");
				int tmpid=s.nextInt();
				String name=s.next();
				int age=s.nextInt();
				String btype=s.next();
				eDao.update(tmpid, name, age, btype);
			}
				break;
				//emp e=new 
			}
		}
	}
}
