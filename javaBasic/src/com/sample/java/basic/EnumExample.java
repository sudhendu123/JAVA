package com.sample.java.basic;

import java.util.HashMap;
import java.util.Map;

//The Enum in Java is a data type which contains a fixed set of constants.
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
		Day day1=Day.THURUSDAY;
		System.out.println("equals="+day.equals(day));
		System.out.println("equals="+day.equals(day1));
		
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

enum Element2 {
    H("Hydrogen"),
    HE("Helium"),
    LI("Lithium"),
    BE("Beryllium"),
    B("Boron"),
    C("Carbon"),
    N("Nitrogen"),
    O("Oxygen"),
    F("Flourine"),
    NE("Neon");

    /** a final variable to store the label, which can't be changed */
    public final String label;

    /**
     * A private constructor that sets the label.
     * @param label 
     */
    private Element2(String label) {
        this.label = label;
    }

    /**
     * Look up Element2 instances by the label field. This implementation iterates through 
     * the values() list to find the label.
     * @param label The label to look up
     * @return The Element2 instance with the label, or null if not found.
     */
    public static Element2 valueOfLabel(String label) {
        for (Element2 e2 : values()) {
            if (e2.label.equals(label)) {
                return e2;
            }
        }
        return null;
    }

    /**
     * Override the toString() method to return the label instead of the declared name.
     * @return 
     */
    @Override
    public String toString() {
        return this.label;
    }
}

enum Element3 {
    H("Hydrogen"),
    HE("Helium"),
    LI("Lithium"),
    BE("Beryllium"),
    B("Boron"),
    C("Carbon"),
    N("Nitrogen"),
    O("Oxygen"),
    F("Flourine"),
    NE("Neon");

    /** 
     * A map to cache labels and their associated Element3 instances.
     * Note that this only works if the labels are all unique!
     */
    private static final Map<String, Element3> BY_LABEL = new HashMap<>();
    
    /** populate the BY_LABEL cache */
    static {
        for (Element3 e3 : values()) {
            BY_LABEL.put(e3.label, e3);
        }
    }

    /** a final variable to store the label, which can't be changed */
    public final String label;

    /**
     * A private constructor that sets the label.
     * @param label 
     */
    private Element3(String label) {
        this.label = label;
    }

    /**
     * Look up Element2 instances by the label field. This implementation finds the
     * label in the BY_LABEL cache.
     * @param label The label to look up
     * @return The Element3 instance with the label, or null if not found.
     */
    public static Element3 valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    /**
     * Override the toString() method to return the label instead of the declared name.
     * @return 
     */
    @Override
    public String toString() {
        return this.label;
    }
}

interface Labeled {
    String label();
}

enum Element4 implements Labeled {
    H("Hydrogen", 1, 1.008f),
    HE("Helium", 2, 4.0026f),
    LI("Lithium", 3, 6.94f),
    BE("Beryllium", 4, 9.01722f),
    B("Boron", 5, 10.81f),
    C("Carbon", 6, 12.011f),
    N("Nitrogen", 7, 14.007f),
    O("Oxygen", 8, 15.999f),
    F("Flourine", 9, 18.998f),
    NE("Neon", 10, 20.180f);
    /** 
     * Maps cache labels and their associated Element3 instances.
     * Note that this only works if the values are all unique!
     */
    private static final Map<String, Element4> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Element4> BY_ATOMIC_NUMBER = new HashMap<>();
    private static final Map<Float, Element4> BY_ATOMIC_WEIGHT = new HashMap<>();
    
    /** populate the caches */
    static {
        for (Element4 e4 : values()) {
            BY_LABEL.put(e4.label, e4);
            BY_ATOMIC_NUMBER.put(e4.atomicNumber, e4);
            BY_ATOMIC_WEIGHT.put(e4.atomicWeight, e4);
        }
    }

    /** final variables to store the values, which can't be changed */
    public final String label;
    public final int atomicNumber;
    public final float atomicWeight;

    private Element4(String label, int atomicNumber, float atomicWeight) {
        this.label = label;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
    }

    /**
     * Implement the Labeled interface.
     * @return the label value
     */
    @Override
    public String label() {
        return label;
    }

    /**
     * Look up Element2 instances by the label field. This implementation finds the
     * label in the BY_LABEL cache.
     * @param label The label to look up
     * @return The Element4 instance with the label, or null if not found.
     */
    public static Element4 valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    /**
     * Look up Element2 instances by the atomicNumber field. This implementation finds the
     * atomicNUmber in the cache.
     * @param number The atomicNumber to look up 
     * @return The Element4 instance with the label, or null if not found.
     */
    public static Element4 valueOfAtomicNumber(int number) {
        return BY_ATOMIC_NUMBER.get(number);
    }

    /**
     * Look up Element2 instances by the atomicWeight field. This implementation finds the
     * atomic weight in the cache.
     * @param weight the atomic weight to look up
     * @return The Element4 instance with the label, or null if not found.
     */
    public static Element4 valueOfAtomicWeight(float weight) {
        return BY_ATOMIC_WEIGHT.get(weight);
    }

    /**
     * Override the toString() method to return the label instead of the declared name.
     * @return 
     */
    @Override
    public String toString() {
        return this.label;
    }
}