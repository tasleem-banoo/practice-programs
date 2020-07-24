package com.demo.programs.controller;

public class TypeInterfaceExample {

	public static void main(String[] args) {
		//It will decide type based on interface. We can get rid of type also in input arg 
		//in lambda funtion. It will identify based on interface. (String s) same as (s)
		//If only one arg, we can remove () also. (s) same as s
		StringLengthLamda lengthLambdaFunc = s -> s.length();
		System.out.println(lengthLambdaFunc.getLength("Tasleem"));
		
		printLength(s -> s.length());

	}
	
	public static void printLength(StringLengthLamda l) {
		System.out.println(l.getLength("Hello!"));
	}
	
	interface StringLengthLamda {
		int getLength(String s);
	}

}
