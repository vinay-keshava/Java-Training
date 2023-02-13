package Collections;
import java.util.*;
public class DemoQueue {

	public static void main(String[] args) {
		PriorityQueue <Integer> i=new PriorityQueue<Integer>();
		i.add(30);	
		i.add(90);	
		i.add(16);	
		i.add(7);   
		i.add(27);	
		Iterator iterator = i.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        
                 }

//        System.out.println(i);

	}
	

}
