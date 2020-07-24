package com.demo.programs.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(new Person("Tasleem","Banoo",29),
				new Person("Amit","Sharma",28),
				new Person("Palak","Sharma",30),
				new Person("Saurabh","Tiwari",29)
				);
		
		System.out.println("Prints all persons in list");
		//In this we are calling println on instance. use syntax instance :: method name
		performConditionally(persons, p -> true, System.out :: println); // p -> method(p)
	}

	private static void performConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p:persons) {
			if(predicate.test(p))
			consumer.accept(p);
		}
		
	}
}
