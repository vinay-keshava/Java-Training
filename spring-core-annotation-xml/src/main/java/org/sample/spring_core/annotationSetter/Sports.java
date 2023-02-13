package org.sample.spring_core.annotationSetter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component (value = "football")
public class Sports {
	String name;

	public String getName() {
		return name;
	}
	@Value (value = "cricket")
	public void setName(String name) {
		this.name = name;
	}
}
