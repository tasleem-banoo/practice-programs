package com.demo.programs.controller;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		//Thread t = new Thread(() -> printMessage());
		
		//if there is no arg method, then use below syntax Class name :: method name 
		//for static method call
		Thread t = new Thread(MethodReferenceExample::printMessage); // () -> method()
		
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello! Method Reference Example");
	}

}
