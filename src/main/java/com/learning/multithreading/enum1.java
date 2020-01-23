package com.learning.multithreading;

enum Days{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
}


class enum1{
	
	Days day;
	private enum1(Days day){
		this.day=day;
	}
	
	//Defined Switch statement as per the requirement
	public void daysBeLike(){
		switch(day){
		
		case MONDAY:System.out.println("MONDAY are bad");
					break;
		case TUESDAY:System.out.println("Tuesday are ok");
		break;

		case SATURDAY:System.out.println("Saturday are best");
		
		
		default:System.out.println("ALL days are ok");
		}
	}
	
	public static void main(String[] args){
		String str = "SATURDAY";
		enum1 obj = new enum1(Days.valueOf(str)); //This line is equivalent to enum1 obj = new enum("SATURDAY");
		//Control will move to constructor will we will assign saturday value to Instance Days refernece.
		obj.daysBeLike();
	System.out.println(Days.MONDAY.getClass());
	}
	
	
}