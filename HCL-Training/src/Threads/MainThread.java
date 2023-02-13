package Threads;

public class MainThread {
public static void main(String[] args) {
	Thread t=Thread.currentThread();
	System.out.println(t.getName());
	t.setName("Vinay->MainMethod");
	System.out.println(t.getName());
	try {
		t.getPriority();
		t.sleep(9000);
		static void sleep(long milliseconds) throws InterruptedException
	} catch (Exception e) {
		// TODO: handle exception
	}
	System.out.println(t.getId());
}
}
