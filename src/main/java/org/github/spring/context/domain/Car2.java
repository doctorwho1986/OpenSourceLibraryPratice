package org.github.spring.context.domain;

import org.springframework.stereotype.Component;

@Component
public class Car2 implements Car {

	public String info() {
		return getClass().getName();
	}

}
