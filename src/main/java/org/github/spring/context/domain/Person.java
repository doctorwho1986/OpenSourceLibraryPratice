package org.github.spring.context.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	
	@Autowired
	private List<Car> cars; //  list 列表注入
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Car> getCars() {
		return cars;
	}
}
