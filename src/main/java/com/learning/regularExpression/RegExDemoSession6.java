/*
 * Write a program to check whether the given mail id is valid or not
 */

package com.learning.regularExpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemoSession6 {
	
	public static Scanner scan = new Scanner(System.in);


	public static void main(String[] args) {

		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+");
		String matcher = scan.next();
		Matcher m = p.matcher(matcher);
		
		if(m.find()&&m.group().equals(matcher)) {
			System.out.println("Valid Email id");
		}else {
			System.out.println("Invalid Mail Id");
		}

	}}
