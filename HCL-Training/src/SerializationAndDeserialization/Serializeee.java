package SerializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializeee {
		public static void main(String[] args) {
			Employee e=new Employee();
			e.name="Vinay";
			e.addr="Bengaluru";
			e.age=2123;
			try {
				FileOutputStream fout=new FileOutputStream("/tmp/hello.txt");
				ObjectOutputStream s=new ObjectOutputStream(fout);
				s.writeObject(e);
				s.close();
				fout.close();
				System.out.println("Seriliazed data is stored to /tmp/hello.txt");
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		
	}

}
