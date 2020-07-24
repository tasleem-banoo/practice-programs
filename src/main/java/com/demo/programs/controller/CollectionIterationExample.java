package com.demo.programs.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionIterationExample {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Tasleem","Banoo",29),
				new Person("Amit","Sharma",28),
				new Person("Palak","Sharma",30),
				new Person("Saurabh","Tiwari",29)
				);
		
		System.out.println("--Using for loop--");
		for(int i=0;i<persons.size();i++) {
			System.out.println(persons.get(i));
		}
		
		System.out.println("--Using for-in/for-each loop--");
		for(Person p:persons) {
			System.out.println(p);
		}
		
		System.out.println("--Using lambda foreach method--");
		//persons.forEach(p -> System.out.println(p));
		persons.forEach(System.out :: println);
		
		System.out.println("--Using streams--");
		//Streams - a sequence of elements supporting sequential and parallel aggregate operations
		//stream() will put all persons on conveyer belt , then for each element in conveyer belt we will print out person first name.
		//right now only one person is working on this list
		//persons.stream().forEach(p -> System.out.println(p.getFirstName()));
		
		//now two person is working on this list i.e two operations are performing. if it passes one then only it will go to second
		persons.stream()
		.filter(p-> p.getLastName().startsWith("S"))
		.forEach(p -> System.out.println(p.getFirstName()));
		
		//parallelStream could potentially split collection into multiple stream. different portion can be handled differently
		long count = persons.stream()
		.filter(p-> p.getLastName().startsWith("S"))
		.count();
		System.out.println(count);
	}
}
