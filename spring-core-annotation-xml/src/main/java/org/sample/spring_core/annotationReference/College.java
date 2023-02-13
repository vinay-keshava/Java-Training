package org.sample.spring_core.annotationReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component (value="aiet")
public class College {

	@Autowired
	Branch branch;
	public void getCollege() {
		branch.getBranch();
	}
	
	
	
}
