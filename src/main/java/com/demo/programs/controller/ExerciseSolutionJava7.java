package com.demo.programs.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseSolutionJava7 {
	
	public static void main(String args[]) {
		
		List<Person> persons = Arrays.asList(new Person("Tasleem","Banoo",29),
				new Person("Amit","Sharma",28),
				new Person("Palak","Sharma",30),
				new Person("Saurabh","Tiwari",29)
				);
		
		//1: sort list by last name
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
			
		});
		
		//2: prints all elements in list
		System.out.println("Prints all persons in list");
		printAll(persons);
		
		//3: prints element last name beginning with s
		System.out.println("Prints all person in list having last name beginning with S");
		printByLastName(persons);
		
		System.out.println("Prints all person in list having last name beginning with S");
		printConditionally(persons, new Condition() {
			
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("S");
			}
		});
		
		System.out.println("Prints all person in list having last name beginning with B");
		printConditionally(persons, new Condition() {
			
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("B");
			}
		});
	}

	private static void printConditionally(List<Person> persons, Condition condition) {
		for(Person p:persons) {
			if(condition.test(p))
			System.out.println(p);
		}
		
	}

	private static void printByLastName(List<Person> persons) {
		for(Person p:persons) {
			if(p.getLastName().startsWith("S"))
			System.out.println(p);
		}
		
	}

	private static void printAll(List<Person> persons) {
		for(Person p:persons) {
			System.out.println(p);
		}
		
	}

}

//this is an overhead. So java designer created some out of the box interface to address common scenario
//so we don't need to create interface
//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
interface Condition {
	boolean test(Person p);
}
