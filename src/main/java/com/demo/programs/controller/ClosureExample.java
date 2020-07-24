package com.demo.programs.controller;

public class ClosureExample {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		//compiler will keep track of value b. In java7 we need to put final but in java8 it is not required. but if we change it will give compile time issue 
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i+b);
			}
		});
		
		//where is b coming from? It is coming from closure.
		//whenever there is lambda expression and it is using someting/variable in scope
		//java compiler freeze that value along with lambda expression
		doProcess(a, i -> System.out.println(i+b));
	}
	
	public static void doProcess(int i,Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}
