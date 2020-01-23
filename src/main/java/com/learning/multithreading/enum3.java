package com.learning.multithreading;


enum Color{
	
	RED,BLUE,GREEN,YELLOW;

	
	//Defining Constructor
	
	private Color(){
		System.out.println("Constructor called for"+ this.toString());
	}
	
	public void currentColor(){
		System.out.println("UNiversla COlor");
	}
}


public class enum3{
	
	public static void main(String[] args){
		
		Color obj = Color.RED;
		System.out.println(obj);
		obj.currentColor();
	}
	
	
	
	
	
	
	
}
	
