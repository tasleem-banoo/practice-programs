package com.demo.programs.controller;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("From Runnable inner class");
				
			}
		});
		myThread.run();
		
		//Lambda behaves like an instance of what it tries to match as an interface. Thread class will accept
		//interface. So we created lambda function with runnable interface as type.
		//Interface with only one abstract method is functional interface. It can have many concrete methods.
		Thread myLambdaThread = new Thread(() -> System.out.println("From Lambda Fucntion"));
		myLambdaThread.run();
		

	}

}
