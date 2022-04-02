package com.sample.java.prgm;

public class Operators {
	public static void main(String args[]) {
		
		postFix();
		preFix();
		unaryOperator();
		arthmaticOperator();
		shiftOperator();
		ternaryOperator();
		bitwiseOperator1();
	}

	public static void postFix() {
		// Postfix(y’s value is previous value of x contained,but x’s value is same as
		// prefix x value)
		// Post fix(if single valued then pre and post are same value if its assigned to
		// another variable the they show pre or post property)
		// If another variable hold the value of ‘x’ then in
		// Prefix=current value of x
		// Postfix= previous value of x
		// If we print the value of x in case of pre or post,Then prefix=postfix
		int x = 10, y;
		y = x++;// y=x=10,x=11
		System.out.println(y);// 10
		y = x--;// y=x+1=11,x=10
		System.out.println(y);// 11
		y = x; // y=x-1=10,x=10
		System.out.println(y);// 10
	}

	public static void preFix() {
		// Prefix (what ever is x value that’s is y’s value,x value is incremented or
		// decremented as the operator)
		int x = 10, y;
		y = ++x;// y=x+1
		System.out.println(y);// 11
		y = --x;// y=x-1
		System.out.println(y);// 10
		y = x; // y=x
		System.out.println(y);// 10

		y = x++;
		System.out.println(y);// 10
		y = x--;
		System.out.println(y);// 11
		System.out.println(y);// 11
		System.out.println(y);// 11

		y = x++;// y=x=10
		System.out.println(y);// 10
		y = x--;// y=x+1=11
		y = x--;// y=x-1=10
		y = x--;// y=x-1=9
		System.out.println(y);// 9

		x++;// x=x+1=11
		System.out.println(x);// 11
		x++;// x=x+1=12
		System.out.println(x);// 12
		x--;// x=x-1=11
		System.out.println(x);// 11
		x--;// x=x-1=10
		System.out.println(x);// 10
	}

	public static void unaryOperator() {
		// postfix expr++ expr--
		// prefix ++expr --expr +expr -expr ~ !
		// Bitwise Complement(~)
		// NOT’ Operator(!)
		int a = 10;
		int b = -10;
		boolean c = true;
		boolean d = false;
		System.out.println(~a);// -11 (minus of total positive value which starts from 0)
		System.out.println(~b);// 9 (positive of total minus, positive starts from 0)
		System.out.println(!c);// false (opposite of boolean value)
		System.out.println(!d);// true
		// 16 digits number with 1's complement of the input digit
		// 99(1100011)=1s(0011100)=~99(1111111110011100)(-100)
		// 110(6)=1s(001)(1)=2's(1+1=2)(010) 2's is 1s+1
		byte by = ~4;// ~4(100)=1111111111111 011(-5)
		System.out.println("~4 " + by);// ~1101(13) = 111111111111 0010(-14)
		postFix();
		preFix();
	}

	public static void arthmaticOperator() {
		int a = 10;
		int b = 5;
		// multiplicative * / %
		// additive + -
		System.out.println(a + b);// 15
		System.out.println(a - b);// 5
		System.out.println(a * b);// 50
		System.out.println(a / b);// 2
		System.out.println(a % b);// 0
	}

	public static void shiftOperator() {
		leftShiftOperator();
		rightShiftOperator();
		rightSignedShiftOperator();
	}

	public static void leftShiftOperator() {
		//Bitwise Left Shift Operator (<<)
		System.out.println(10 << 2);// 10*2^2=10*4=40
		System.out.println(10 << 3);// 10*2^3=10*8=80
		System.out.println(20 << 2);// 20*2^2=20*4=80
		System.out.println(15 << 4);// 15*2^4=15*16=240
	}

	public static void rightShiftOperator() {
		//Bitwise Right Shift Operator
		System.out.println(10 >> 2);// 10/2^2=10/4=2
		System.out.println(20 >> 2);// 20/2^2=20/4=5
		System.out.println(20 >> 3);// 20/2^3=20/8=2
	}

	public static void rightSignedShiftOperator() {
		//Bitwise Zero Fill Right Shift Operator (>>>)
		// The>> operator is a signed right shift operator and >>> is an unsigned right
		// shift operator.
		// For positive number, >> and >>> works same
		System.out.println(20 >> 2);
		System.out.println(20 >>> 2);
		// For negative number, >>> changes parity bit (MSB) to 0
		System.out.println(-20 >> 2);//-5          				  1111111111111011
		System.out.println(-20 >>> 2);//1073741819 11111111111111 1111111111111011(30 digit)
		System.out.println(-10 >> 2);//-3						   1111111111111101
		System.out.println(-10 >>> 2);//1073741821	11111111111111 1111111111111101	(30 digit)
	}
	
	/**
	 * If the condition is true, the result of ? is returned. 
	 * But, if the condition is false, the result of : is returned.
	 * condition?true:false
	 */

	public static void ternaryOperator() {
		int a = 2;
		int b = 5;
		int min = (a < b) ? a : b;
		System.out.println(min);
	}

	public static void assignmentOperator() {

		int a = 10;
		int b = 20;
		a += 4;// a=a+4 (a=10+4)
		b -= 4;// b=b-4 (b=20-4)
		System.out.println(a);
		System.out.println(b);
		a += 3;// 10+3
		System.out.println(a);
		a -= 4;// 13-4
		System.out.println(a);
		a *= 2;// 9*2
		System.out.println(a);
		a /= 2;// 18/2
		System.out.println(a);
	}

	public static void assignmentOperator1() {
		short a = 10;
		short b = 10;
		// a+=b;//a=a+b internally so fine
		// a=a+b;//Compile time error because 10+10=20 now int
		a = (short) (a + b);// 20 which is int now converted to short
		System.out.println(a);

	}

	public static void bitwiseOperator1() {
		//bitwise AND	&, Bitwise AND operator: returns bit by bit AND of input values.
		//bitwise exclusive OR	^ ,Bitwise XOR operator: returns bit by bit XOR of input values,
		//^ takes two boolean operands and returns true if they are different
		//bitwise inclusive OR	|, Bitwise OR operator: returns bit by bit OR of input values.
		String s=null;
		// as 1st exp is false result is false doesnt go to 2nd exp
		System.out.println(s!=null&&s.isEmpty());//false
		//& always compares both so NPE will happen
		System.out.println(s!=null&s.isEmpty());//NPE
		//100(4) & 101(5)=100(4)
		System.out.println(4&5);
		
		int x = 5, y = 7;   //declaring values  
		// bitwise XOR     
		// 0101 ^ 0111 = 0101 = 2    
		// Performing an operation with xor and traditional operator   
		System.out.println("x ^ y = " + (x ^ y));     
		
		boolean a=true,b=false;
		System.out.println("a ^ b = " + (a ^ b)); //true
		
		boolean c=false,d=true;
		System.out.println("c ^ d = " + (c ^ d)); //true
		
		boolean e=false,f=false;
		System.out.println("e ^ f = " + (e ^ f)); //false
		
		boolean g=true,h=true;
		System.out.println("g ^ h = " + (g ^ h)); //false
	}
}
