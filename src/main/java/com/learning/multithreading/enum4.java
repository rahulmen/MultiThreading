package com.learning.multithreading;


enum Signal{


	RED("Stop"),YELLOW("SlowDown"),GREEN("Go");
	
	
	String signal;
	
	private Signal(String signal){
	this.signal=signal;	
	}
	
	public  String getAction(){
		return this.signal;
	}
	
}

public class enum4{
	
	public static void main(String[] args){
		
		Signal[] str = Signal.values();
		
		for(Signal str1 : str){
			
			System.out.println("Current Signal :"+" "+str1.name()+" "+"Action :"+" "+str1.getAction());
			
		}
		
	}
	
	
}
	
