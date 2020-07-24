package com.demo.programs.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramsController {

	@GetMapping("/reverseString/{value}")
	public String reverseString(@PathVariable String value) {
		
		//StringBuilder builder = new StringBuilder(value);
		//return builder.reverse().toString();
		
		/*
		 * String reverseString = null; 
		 * char[] charArray = value.toCharArray(); 
		 * for(int count=charArray.length-1;count>=0;count--) 
		 * { 
		 * if(count==charArray.length-1) {
		 * reverseString=""; 
		 * } 
		 * reverseString+=charArray[count];
		 * System.out.print(charArray[count]); 
		 * } 
		 * return reverseString;
		 */
		
		//return reverseRecursiveWay(value);
		
		char[] tempArray = value.toCharArray();
		int left,right = 0;
		right = tempArray.length-1;
		for (left=0; left<right; left ++, right--) {
			char temp = tempArray[left];
			tempArray[left]= tempArray[right];
			tempArray[right]=temp;
		}
		for(char val:tempArray) {
			System.out.print(val);
		}
		return "";
	}

	private String reverseRecursiveWay(String value) {
		if(value.isEmpty())
			return value;
		return reverseRecursiveWay(value.substring(1))+value.charAt(0);
	}
	
	@GetMapping("/hasAllUniqueChars/{value}")
	public boolean stringhasUniqueChars(@PathVariable String value) {
		Set<Character> charsSet = new HashSet<Character>();
		boolean result = false;
		for(int count=0;count<value.length();count++) {
			result = charsSet.add(value.charAt(count));
			if(!result) {
				break;
			}
		}
		return result;
	}
	
	@GetMapping("/firstNonRepeatedChar/{value}")
	public char nonRepeatedChars(@PathVariable String value) {
		/*
		 * Map<Character,Integer> charsMap = new HashMap<Character, Integer>(); 
		 * for(int count=0;count<value.length();count++) {
		 * if(charsMap.containsKey(value.charAt(count))) {
		 * charsMap.put(value.charAt(count),charsMap.get(value.charAt(count))+1); 
		 * } else
		 * charsMap.put(value.charAt(count),1); 
		 * } 
		 * for(int count=0;count<value.length();count++) 
		 * { char c= value.charAt(count);
		 * if(charsMap.get(c)==1) 
		 * return c; 
		 * }
		 * 
		 * return '-';
		 */
		
		for (char c:value.toCharArray()) {
			if(value.indexOf(c)==value.lastIndexOf(c))
				return c;
		}
		
		return '-';
	}
	
	@GetMapping("/arrayIntersection")
	public int[] nonRepeatedChars() {
		int[] firstArray = {1,2,3,4,5};
		int[] secondArray = new int[] {5,6,7,8,1};
		int[] intersectedArray = new int[firstArray.length+secondArray.length];
		int c=0;
		for(int i=0;i<firstArray.length;i++) {
			for(int j=0;j<secondArray.length;j++) {
				if(firstArray[i]==secondArray[j]) {
					intersectedArray[c]=firstArray[i];
					c++;
				} else {
					continue;
				}
			}
		}
		for(int i=0;i<c;i++) {
			System.out.print(intersectedArray[i]);
		}
		return intersectedArray;
	}
	
	@GetMapping("/noOfWords/{value}")
	public int numberOfWordsInString(@PathVariable String value) {
		
		char ch[]= new char[value.length()]; 
		int c=0;
		for(int i=0;i<value.length();i++) {
			 ch[i]= value.charAt(i);
	         if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
	         c++;
		}
		System.out.println(c);
		return value.trim().split("\\s+").length;
	}
	
	@GetMapping("/removeWhiteSpace/{value}")
	public String removeWhiteSpace(@PathVariable String value) {
		
		for(int i=0;i<value.length();i++) {
			if(value.charAt(i)!=' ') {
				System.out.print(value.charAt(i));
			}
		}
		return value.trim().replaceAll("\\s+","");
	}
	
	@GetMapping("/armstrongNumber/{value}")
	public String armstrongNumber(@PathVariable int value) {
		
		int origValue = value;
		int sum = 0;
		while(value != 0) {

		int r = value % 10;
		sum = sum+ r*r*r;
		value /= 10;
		}
		if(sum==origValue)
			return "It is armstrong number "+origValue;
		return "Not a armstrong number "+origValue;
	}
}
