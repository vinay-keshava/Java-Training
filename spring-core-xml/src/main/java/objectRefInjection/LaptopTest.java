package objectRefInjection;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaptopTest {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext cac=new ClassPathXmlApplicationContext("objectRefSetterInjection.xml");
		Laptop newHP = (Laptop) cac.getBean("myHPLaptop");
		newHP.getLaptop();
		
	}

}
