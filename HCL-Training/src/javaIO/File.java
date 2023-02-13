package javaIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class File {

	public static void main(String[] args) {
	//Writing onto Fileee
		try {
			FileOutputStream fout=new FileOutputStream("/tmp/hi.txt");
			fout.write(65);
			//here 65 is the ascii code hence the character "A" is written onto the file hi.txt			
			fout.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try {
			FileOutputStream s=new FileOutputStream("/tmp/strout.txt");
			String str="Hello World This is writing onto the file using byte array\n";
			byte b[] =str.getBytes();
			s.write(b);
			s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		//Reading from file
		try {
			FileInputStream fin=new FileInputStream("/tmp/hello.txt");
			int i=fin.read();
			System.out.println((char)i);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
