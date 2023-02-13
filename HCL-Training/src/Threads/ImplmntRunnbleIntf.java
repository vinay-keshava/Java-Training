package Threads;

public class ImplmntRunnbleIntf implements Runnable{
	
	public void run() {
		System.out.println("Thread is Running (Executed by implementing runnable interface)");
	}
	
	public static void main(String args[])
	{
		ImplmntRunnbleIntf ir=new ImplmntRunnbleIntf();
		Thread t1=new Thread(ir);
		t1.start();
	}
	
}
