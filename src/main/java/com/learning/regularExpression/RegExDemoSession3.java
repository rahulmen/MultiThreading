package com.learning.regularExpression;

import java.util.regex.Pattern;

public class RegExDemoSession3 {
	
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("[.]");  //  Important :- [.] or //.
		String[] s = p.split("rahul.mendiratta13@gmail.com");
		
		for(String s1:s) {
			System.out.println(s1);
		}

}}
