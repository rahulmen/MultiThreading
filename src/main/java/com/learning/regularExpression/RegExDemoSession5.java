/*
 * Write a program to check whether the given number is a valid mobile number or not 

 */

package com.learning.regularExpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemoSession5 {
	
	public static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) {

		Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		String matcher = scan.next();
		Matcher m = p.matcher(matcher);
		
		if(m.find()&&m.group().equals(matcher)) {
			System.out.println("Valid Mobile Number");
		}else {
			System.out.println("Invalid Mobile Number");
		}

	}}
