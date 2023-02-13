package SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializeeeee {

	public static void main(String[] args) {
		Employee e=null;
		try {
			FileInputStream fout=new FileInputStream("/tmp/hello.txt");	
			ObjectInputStream ois=new ObjectInputStream(fout);
			e=(Employee) ois.readObject();
			fout.close();
			ois.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		System.out.println(e.addr);
		System.out.println(e.age);
		System.out.println(e.name);
	}

}
