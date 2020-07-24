package com.demo.programs.controller;

public class ThisReferenceExample {
	
	public void doProcess(int i,Process p) {
		p.process(i);
	}
	
	public static void main (String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
		//this reference will work in anonymous inner class but not in lambda expression
		//this reference refer to instance of anonymous class
		//anonymous inner class override this reference but not in lambda. lambda refers to outer this reference
		/*thisReferenceExample.doProcess(10, new Process() {
			
			@Override
			public void process(int i) {
				System.out.println("Value of i is "+i+ " This reference "+this);
			}
			
			public String toString() {
				return "This is anonymous inner class";
			}
		});*/
		
		//lambda treats this reference in a different way then anonymous class.
		//in lambda, instance of lambda does not touch this reference. this reference is 
		//unmodified when we are using it in lambda expression. This is by design
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is "+i);
			//System.out.println("This reference "+this);  //does not work
			});
		
		thisReferenceExample.execute();
	}
	
	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value of i is "+i);
			System.out.println("This reference "+this); //now it will refer to outer class reference. lambda will not modify it
			});
	}
	
	public String toString() {
		return "outer to string method";
	}

}
