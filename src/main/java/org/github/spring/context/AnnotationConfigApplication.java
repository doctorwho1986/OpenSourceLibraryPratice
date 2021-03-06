package org.github.spring.context;

import java.util.List;
import java.util.Map;

import org.github.spring.context.domain.Car;
import org.github.spring.context.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplication {
	public static void main(String[] args) {
		//零配置
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("org.github.spring.context.domain");
		applicationContext.refresh();
		Person person = applicationContext.getBean("person",Person.class);
		if (null == person) {
			System.err.println("null");
		}else {
			person.setName("doctor");
			System.out.println(person.getName());
			List<Car> cars = person.getCars();
			System.out.println(cars.getClass().getName());
			System.out.println(cars);
			
			System.out.println("////////////////////////////");
			Map<String, Car> mapCars = person.getMapCars();
			for (String car : mapCars.keySet()) {
				System.out.println(car + " : " + mapCars.get(car));
			}
		}
		
		applicationContext.close();
	}
}
