package com.github.spring;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public class ReflectionUtilsP {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Person person = new Person();
		person.setAddress("no address");
		person.setName("doctor");
		person.setAge(1000);
		System.out.println(person);
		Field field = person.getClass().getDeclaredField("name");
		field.setAccessible(true);
		ReflectionUtils.setField(field, person, "set doctor");
		System.out.println(person);
		

	}

}

class Person{
	private String name;
	private String address;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuffer stringBuffer = new StringBuffer(216);
		stringBuffer.append("{");
		try {
			for (Field field : fields) {
				stringBuffer.append(field.getName()).append(":").append(field.get(this));
				stringBuffer.append(",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
		stringBuffer.append("}");
		return stringBuffer.toString();
		
	}
}
