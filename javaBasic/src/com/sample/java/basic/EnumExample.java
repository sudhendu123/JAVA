package com.sample.java.basic;

public class EnumExample {
	public enum Season { WINTER, SPRING, SUMMER, FALL }  
	  
	public static void main(String[] args) {  
	
		for (Season s : Season.values())  
			System.out.println(s); 
		System.out.println("-----------week-----------");
		for (Day w : Day.values())  
			System.out.println(w+":"+w.getValue()+":"+w.value);  
		System.out.println("-----------day-----------");
		Day monday = Day.MONDAY;
		System.out.println(monday);
		
		Day[] val = Day.values();
		
		Day day=Day.MONDAY;  
		  
		switch(day){  
		case SUNDAY:   
		 System.out.println("sunday");  
		 break;  
		case MONDAY:   
		 System.out.println("monday");  
		 break;  
		default:  
		System.out.println("other day");  
	}
}

}
enum Day{
	MONDAY(1),TUESDAY(2),WEDNEADAY(3),THURUSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);
	//changed the visibility to default to be accessed out side package if private cannot be accessed.
	int value;
	//private constructor
	private Day(int value){  
		this.value=value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}  
	
}