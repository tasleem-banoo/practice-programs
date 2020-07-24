package com.demo.programs.controller;

//this annotation will give clue to other developer that this is meant to be functional interface
//no other abstrct method can be added to this. It will give error if added another method
@FunctionalInterface
public interface ILambdaBasic {

	public void perform();
	
}
