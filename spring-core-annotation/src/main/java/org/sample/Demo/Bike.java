package org.sample.Demo;

import org.springframework.stereotype.Component;


@Component (value="myBike")
public class Bike {

	public void getBike() {
		System.out.println("RE Loading");
	}
}
