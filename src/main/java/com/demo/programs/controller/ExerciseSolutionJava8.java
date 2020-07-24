package com.demo.programs.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExerciseSolutionJava8 {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(new Person("Tasleem","Banoo",29),
				new Person("Amit","Sharma",28),
				new Person("Palak","Sharma",30),
				new Person("Saurabh","Tiwari",29)
				);
		
		//1: sort list by last name
		Collections.sort(persons, (p1, p2) ->  p1.getLastName().compareTo(p2.getLastName()));
		
		
		//2: prints all elements in list
		System.out.println("Prints all persons in list");
		//printConditionally(persons, p -> true);
		performConditionally(persons, p -> true, p-> System.out.println(p));
		
		//3: prints element last name beginning with s
		System.out.println("Prints all person in list having last name beginning with S");
		//printConditionally(persons,  p ->  p.getLastName().startsWith("S"));
		performConditionally(persons,  p ->  p.getLastName().startsWith("S"), p-> System.out.println(p.getFirstName()));
				
		System.out.println("Prints all person in list having first name beginning with T");
		//printConditionally(persons,  p -> p.getFirstName().startsWith("T"));
		performConditionally(persons,  p -> p.getFirstName().startsWith("T"), p-> System.out.println(p));
		
	}

	private static void printConditionally(List<Person> persons, Predicate<Person> predicate) {
		for(Person p:persons) {
			if(predicate.test(p))
			System.out.println(p);
		}
		
	}
	
	private static void performConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p:persons) {
			if(predicate.test(p))
			consumer.accept(p);
		}
		
	}
}
