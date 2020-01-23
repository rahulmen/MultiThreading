package com.learning.regularExpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemoSession2 {
	
	private static String pattern;
	private static String matcher;
	private static int count=0;
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter the pattern to be searched: ");
		pattern = scan.next();
		System.out.println();
		System.out.print("String Where to search:");
		matcher = scan.next();
		scan.close();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(matcher);
		
		while(m.find()) {
			count++;
			System.out.print(m.start()+"-"+m.end()+"->"+m.group()+" ,");
		}
		System.out.print("\n"+"The number of occurance is:"+count);
		
	}

}
