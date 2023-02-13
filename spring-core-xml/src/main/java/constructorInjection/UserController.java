package constructorInjection;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac=new ClassPathXmlApplicationContext("constructorInjection.xml");
		User vinay = (User)ac.getBean("userVinay");
		System.out.println(vinay.id);
		System.out.println(vinay.name);
	}

}
