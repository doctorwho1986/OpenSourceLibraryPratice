package org.github.spring.context.domain;

import org.springframework.stereotype.Component;

@Component
public class Car1 implements Car {

	public String info() {
		return getClass().getName();
	}

}
