import java.util.HashSet;
import java.util.Iterator;
public class DemoHashSet {

	public static void main(String[] args) {
		HashSet <Integer> hs=new HashSet <Integer>(10);
			hs.add(200);
			hs.add(400);
			Iterator <Integer> i=hs.iterator();
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
			
			
			//User defined type of HashSet
			HashSet <School> hashSchool =new HashSet<School> ();
			School s1=new School(123,"St.John's School",34,40);
			School s2=new School(232,"Kenneth George School",1,2);
			hashSchool.add(s2);
			hashSchool.add(s1);
			
			
		    for(School b:hashSchool){  
		        System.out.println(b.schid+" "+b.name+" "+b.noOfTeachers+" "+b.noOfClasses);  
		        }  
		    
		    //below iterator just prints the address of the each object since initially it consists of the 
			
			Iterator <School> itr=hashSchool.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
	}

}

 class School{
	int schid;
	String name;
	int noOfClasses;
	int noOfTeachers;
	School(int s,String n,int noc,int not)
	{
		this.schid=s;
		this.name=n;
		this.noOfClasses=noc;
		this.noOfTeachers=not;
	}
}
