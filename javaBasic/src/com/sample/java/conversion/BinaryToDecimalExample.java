package com.sample.java.conversion;

import java.util.Scanner;

public class BinaryToDecimalExample {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("1010",2));  
		System.out.println(Integer.parseInt("10101",2));  
		System.out.println(Integer.parseInt("11111",2));  
		Scanner s=new Scanner(System.in);
        
        System.out.println("Enter a binary number:");

        String n=s.nextLine();
        
        System.out.println(Integer.parseInt(n,2));
        
        Scanner s1=new Scanner(System.in);
        
        System.out.println("Enter a binary number:");
        int n1=s1.nextInt();
        
        int decimal=0,p1=0;
        
        while(n1!=0)
        {
            decimal+=((n1%10)*Math.pow(2,p1));
            n1=n1/10;
            p1++;
        }
        
        System.out.println(decimal);
	}
}
