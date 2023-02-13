package Threads;

public class DemoThreadClass {
	
		public static void main(String args[]) {
			Thread t1=new Thread("Thread1");
			t1.start();
			//Getting Thread name
			String str=t1.getName();
			System.out.println("The name of the thread is :"+str);
		}
	
}
