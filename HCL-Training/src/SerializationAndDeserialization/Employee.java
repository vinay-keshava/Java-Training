package SerializationAndDeserialization;

public class Employee implements java.io.Serializable{
	public String name;
	public int age;
	public String addr;
	
	public void empCheck() {
		System.out.println("Hello Employee of ABC Solutions");
		
	}
}
