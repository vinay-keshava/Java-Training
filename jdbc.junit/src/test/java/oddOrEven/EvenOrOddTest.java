package oddOrEven;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.beancontext.BeanContextServiceProviderBeanInfo;

import org.junit.jupiter.api.Test;

class EvenOrOddTest {

	@Test
	void givenNumberEven() {
		EvenOrOdd e=new EvenOrOdd();
		boolean result=e.isNumberEven(20);
		System.out.println(result);
	}
	@Test
	void givenNumberOdd() {
		EvenOrOdd e=new EvenOrOdd();
		boolean result=e.isNumberEven(3);
		System.out.println(result);
	}

}
