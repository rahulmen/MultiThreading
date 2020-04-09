/*
 * Write a program to fetch all mobile number from input file where mobile number are mixed with normal text data and create a output file
 */

package com.learning.regularExpression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemoSession7 {

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter("Output.txt");
		
		Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String line = br.readLine();
		
		while(line!=null) {
			
			Matcher m = p.matcher(line);
			while(m.find()) {
				
				pw.println(m.group());
			}
			line = br.readLine();
			
			
		}
		pw.flush();
		
				
				
		

		
	}}
