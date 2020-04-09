package com.learning.multithreading;




enum enum2{
	
	RED,BLUE,GREEN,YELLOW;
	
	//public static final enum2 RED = new enum2();
	
	public static void main(String[] args){
		//Created Object of enum names enum2
		 // enum2 obj = enum2.RED;
		  ///System.out.println(obj);
		
		
		  enum2 arr[] = enum2.values();
		  
		  for(enum2 arr1:arr){
			  
			  
			  System.out.println(arr1 + " at index " + arr1.ordinal());
			  
			  System.out.println(enum2.valueOf("GREEN"));
			  
			
			  
		  }

		  
		
	}
	
	
}