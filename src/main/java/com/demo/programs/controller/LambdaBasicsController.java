package com.demo.programs.controller;

public class LambdaBasicsController {
	
	public static void main(String args[]) {
		LambdaBasicsController lambController = new LambdaBasicsController();
		
		ILambdaBasic lambdaBasicImpl = new LambdaBasicImpl();
		
		//Lambda function type is interface which has method that signifies action we are performing. 
		//Like this method is void Method. Compiler will look into interface and found one void method.
		//So Lambda method signature is same as functional interface. this interface should contain only one method
		ILambdaBasic basicLambdaFucntion = () -> System.out.println("Hello! I am Basic Lambda Function");
	
		//Object Oriented way of calling method, In this we are passing implementation class which contains
		//function/action that we need to perform. With Lambda we will directly pass function/action to methods.
		lambController.greet(lambdaBasicImpl);
		
		//In this we create class that implemented interface. and logic is in that class
		lambdaBasicImpl.perform();
		
		//In this we are implementing an interface by just implementing function and not a class
		basicLambdaFucntion.perform();
		
		//Lambda is another way of doing this other then anonymous class
		ILambdaBasic innerClass = new ILambdaBasic() {
			@Override
			public void perform() {
				System.out.println("Hello! I am Basic Anonymous Inner Class");
			}
		};
		innerClass.perform();
		
		//Below both looks similar but they are not
		//Advantage of using functional interface is that we can use lambda in place of all those
		//anonymous inner classes and method signature taht accepts interfaces
		lambController.greet(basicLambdaFucntion);
		//lambController.greet(() -> System.out.println("Hello! I am Basic Lambda Function"));
		lambController.greet(innerClass);
		
		//IMyLambdaAdd lambdaAddFunction = (int a, int b) -> a + b;
	
	}
	
	public void greet(ILambdaBasic lambdaBasics) {
		lambdaBasics.perform();
	}
	
	/* Some examples of Lambda functions
	 * public void greet() {
		System.out.println("Basic Lambda Function")
	}*/
	
	/*above greet() method can be converted to below lambda
	1. No need to return type, compiler identifies based on return value
	2. No need to specify method name, as we are referring this with function name
	3. No need to specify modifiers, as it requires in class
	4. just add -> after () and lambda function is complete
	5. If there is only one line in a function we can remove {} also.*/
	//basicLambdaFucntion = () -> System.out.println("Basic Lambda Function");
	
	//no need to specify return also, as it is one line function
	//lambdaFunctionWithArg = (int a) -> a * 2;
	
	//lambdaAddFunction = (int a, int b) -> a + b;
	
	/*lambdaSafeDivideFunction = (int a, int b) -> {
		if(b==0) return 0;
		return a/b;
	};*/
	
	//lambdaStringLengthCountFunc = (String s) -> s.length();

}

/*
 * interface IMyLambdaAdd { int add(int a, int b); }
 */
