import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class DemoArrayList {
	public static void main(String args[])
	{
		ArrayList <Integer> a=new ArrayList<Integer>();
		//Array List maintains insertion order
		
		// Array list is in dynamic in nature.
		a.add(20);
		ArrayList <Integer> sample=new ArrayList<Integer>();
		
		sample.add(20);
		sample.add(200);
		
		a.addAll(sample);
		
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		
		
		
		ArrayList<Integer> abc=new ArrayList<Integer>();
		abc.add(5);
		abc.add(50);
		abc.add(1,500);
		
		//Adding the collection elements into array list from the  particular index
		a.addAll(2,abc);
		a.set(5, 50000); //index,element
		Collections.sort(a);
		System.out.println("Maximum element of the ArrayList"+Collections.max(a));
		System.out.println("Minimum element of the ArrayList"+Collections.min(a));
		
		
		System.out.println("Traversing through the ArrayList");
		System.out.println("Traversing through for loop");
		for(int i=0;i<a.size();i++)
			System.out.print(a.get(i)+" ");

		System.out.println();
		System.out.println("Traversing through iterator");
		Iterator<Integer> itr=a.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		a.remove(0);// 5 is removed from the arrayList
		
		System.out.println("\nFor each loop");
		for(Integer i:a)
			System.out.print(i+" ");
		
		//ArrayList of user defined class objects in ArrayList
			Student s1=new Student(041,"Vinay",20);
			Student s2=new Student(001,"Vicky",22);
		ArrayList <Student> studArryList=new ArrayList <Student>();
		studArryList.add(s1);
		studArryList.add(s2);
		
		
		
		
		
	}
}

class Student{
int rollno;
String fname;
int age;
Student(int r,String f,int a){
	this.rollno=r;
	this.fname=f;
	this.age=a;
}
}
