package com.demo.programs.controller;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambda {
	
	public static void main(String args[]) {
		
		int[] numbers = {1,2,3,4,5};
		int key = 0;
		
		process(numbers,key,(n,k)->System.out.println(n+k));
		
		//this process of handling exception looks not that elegent. We will create another method
		//for handling this. We will wrap lambda in another lambda
		/*process(numbers,key,(n,k)-> {
			try {
				System.out.println(n/k);
			} catch(ArithmeticException e) {
				System.out.println("Exception Occured");
			}
		});*/
		
		process(numbers,key,wrapperLambda((n,k)-> System.out.println(n/k)));
	}
	
	private static void process(int[] numbers,int key, BiConsumer<Integer, Integer> consumer) {
		for(int i: numbers) {
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (n,k) -> {
			try {
				consumer.accept(n, k);
			} catch(ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda");
			}
			
		};
	}

}
