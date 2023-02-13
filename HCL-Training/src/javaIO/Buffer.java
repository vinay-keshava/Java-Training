package javaIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class Buffer {

	public static void main(String[] args) throws Exception {
		FileOutputStream fout=new FileOutputStream("/tmp/hello.txt");
		BufferedOutputStream bout=new BufferedOutputStream(fout);
			String s="Welcome to buffering world";
			byte b[]=s.getBytes();
			bout.write(b);
			bout.flush();
			fout.close();
			System.out.println("Successs");
		
	FileInputStream fin=new FileInputStream("/tmp/strout.txt");		
			
	}

}
