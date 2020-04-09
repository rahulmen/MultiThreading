/*
 * In Properties file both Key and value are String
 */

package com.learning.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample1 {

	private static Properties properties = new Properties();;
	
	public Properties getInstance() {
		return properties;
	}
	
	
	public static void main(String[] args) {
		
		try {
		FileInputStream inputFile = new FileInputStream(System.getProperty("user.dir")+"//"+"demo.properties");
		properties.load(inputFile);
		System.out.println(properties); 
		}catch(FileNotFoundException nsee) {
			nsee.printStackTrace();
		}catch(IOException nsee) {
			nsee.printStackTrace();
		}
		
		System.out.println(properties.getProperty("username"));
		try {
		properties.setProperty("password", "testpassword");
		FileOutputStream outFile = new FileOutputStream(System.getProperty("user.dir")+"//"+"demo.properties");
		properties.store(outFile, "Added By Rahul Mendiratta");
		
		

		
		
		}catch(FileNotFoundException nsee) {
			nsee.printStackTrace();
		}catch(IOException nsee) {
			nsee.printStackTrace();
		}
		
		
		
	}
	
}
