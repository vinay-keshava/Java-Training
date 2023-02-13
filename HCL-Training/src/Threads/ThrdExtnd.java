package Threads;

public class ThrdExtnd extends Thread{
	public void run() {
		System.out.println("thread is running");
	}
	public static void main(String []args)
	{	
		ThrdExtnd t1=new ThrdExtnd();
		t1.start();
	}

}
