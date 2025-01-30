package com.sample.java.prgm.string;

import java.util.Locale;

public class StringTest {

	public static void main(String[] args) {

		char[] charArray = { 'j', 'a', 'v', 'a' };
		String str = new String(charArray);
		// string is immutable so if any char changes in the seq the whole thing is a new object in constant pool.
		// toLowerCase(), toUpperCase

		// In the above statement, either 1 or 2 string will be created.
		// If there is already a string literal “java” in the pool,
		// then only one string “str” will be created in the pool.
		// If there is no string literal “java” in the pool,
		// then it will be first created in the pool and then in the heap space,
		// so a total of 2 string objects will be created.

		// String Literal
		String str1 = "JAVA";
		String str2 = "JAVA"; // will not create new instance

		String string = new String("abc"); // 2 Strings with value "abc" , one on heap and another in String constants
											// pool
		String s = "def"; // String "def" on String constants pool
		s = s + "fgh"; // String "deffgh" on heap and "fgh" on String pool
		// internally compiler does below for + before 1.5 it uses StringBuffer
		// s=new StringBuilder().append("def").append("fgh").toString();
		// so s will now point to deffgh and not def, as no object ref there for def so
		// will be garbage collected.

		String sqt = null;// it will not be created in constant pool.
		String sqtt = "";// will be created in constant pool.
		String ss1 = "Java is easy";
		String ss2 = "java is easy";
		String ss3 = "Java" + " is easy";// compile time
		String ss4 = "Java";
		String ss5 = ss4 + " is easy";// run time
		boolean rq = ss1 == ss2;
		boolean rq1 = ss1 == ss3;
		boolean rq2 = ss1 == ss5;
		boolean rq3 = ss3 == ss5;
		System.out.println("ss1 == ss2 :" + rq);//false
		System.out.println("ss1==ss3 :" + rq1);//true
		System.out.println("ss1==ss5 :" + rq2);//false
		System.out.println("ss3==ss5 :" + rq3);//false
		System.out.println("ss5.hashCode() :" + ss5.hashCode());//-527611558
		System.out.println("ss1.hashCode() :" + ss1.hashCode());//-527611558
		char a = 'a' + 'a';
		System.out.println('H' + 'a'); // o/p 169 add of ascii value
		System.out.println("H" + "a"); // o/p Ha
		System.out.println(a); // o/p Â add ascii and get the asci char
		System.out.println("" + 200 + 'B'); // O/P 200B

		// concat
		String s1 = "Sachin";
		s1 = s.concat(" Tendulkar");
		System.out.println("concat :" + s1);
		// format
		float floatVar = 1.2f;
		int intVar = 12;
		String stringVar = "str";
		String fs = String.format("float 15 spaces 8 decimal " + "%15.8f,  value of the integer "
				+ "variable is %d, and the string " + "is %s", floatVar, intVar, stringVar);
		System.out.println("format: " + fs);
		// charAt
		String s2 = "Strings are immutable";
		char result = s2.charAt(8);
		System.out.println("charAt(8) :" + result);// charAt(8) :a
		// compareTo()
		String strr1 = "Strings are immutable";
		String strr2 = "Strings are immutable";
		String strr3 = "Integers are not immutable";
		String strr4 = "STRING are immutable";
		// It compares strings on the basis of Unicode value of each character in the
		// strings.
		int result1 = strr1.compareTo(strr2);
		System.out.println("strr1.compareTo(strr2):" + result1);// strr1.compareTo(strr2):0 strr1==strr2 equal
		result1 = strr2.compareTo(strr3);
		System.out.println("strr2.compareTo(strr3) :" + result1);// strr2.compareTo(strr3) :10 strr2>strr3 positive
		result1 = strr3.compareTo(strr1);
		System.out.println("strr3.compareTo(strr1) " + result1);// strr3.compareTo(strr1) -10 strr3<strr1 negative
		// compareToIgnoreCase() 
		int result2 = strr4.compareToIgnoreCase(strr2);
		System.out.println("strr4.compareToIgnoreCase(strr2) :" + result2);// strr4.compareToIgnoreCase(strr2) :-83
		// contains The contains() method searches case sensitive char sequence.
		String name = "what do you know about me";
		System.out.println(name.contains("do you know")); // true
		System.out.println(name.contains("about")); // true
		System.out.println(name.contains("About")); // false
		System.out.println(name.contains("hello")); // false
		// endsWith method checks if this string ends with given suffix.
		String ends = "java for human or animal";
		System.out.println("ends.endsWith(\"empty\") :" + ends.endsWith(" ")); // true if space is @last
		System.out.println("ends.endsWith(\"l\") :" + ends.endsWith("l")); // true
		System.out.println("ends.endsWith(\"animal\") :" + ends.endsWith("animal")); // true
		System.out.println("ends.endsWith(\"poin\") :" + ends.endsWith("anima")); // false
		// contentEquals()
		String st1 = "Not immutable";
		String st2 = "Strings are immutable";
		StringBuffer st3 = new StringBuffer("Not immutable");
		boolean result3 = st1.contentEquals(st3);
		System.out.println("st1.contentEquals(st3):" + result3);// st1.contentEquals(st3):true
		result3 = st2.contentEquals(st3);
		System.out.println("st2.contentEquals(st3):" + result3);// st2.contentEquals(st3):false
		// copyValueOf()
		char[] Stt1 = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' };
		String Strtt = "";
		Strtt = String.copyValueOf(Stt1);
		System.out.println("copyValueOf: " + Strtt);// copyValueOf: hello world
		Strtt = String.copyValueOf(Stt1, 2, 6);
		System.out.println("copyValueOf: " + Strtt);// copyValueOf: llo wo
		// substring() 
		String Sr = new String("Welcome to google.com");
		System.out.println("substring :" + Sr.substring(10));// substring : google.com
		System.out.println("substring :" + Sr.substring(10, 15));// substring : goog
		// regionMatches
		String Str11 = new String("Welcome to Tutorialspoint.com");
		String Str22 = new String("Tutorials");
		String Str33 = new String("TUTORIALS");
		System.out.println("regionMatches :" + Str11.regionMatches(11, Str22, 0, 9));// regionMatches :true
		System.out.println("regionMatches:" + Str11.regionMatches(11, Str33, 0, 9));// regionMatches:false
		System.out.println("regionMatches:" + Str11.regionMatches(true, 11, Str33, 0, 9));// regionMatches:true
		// indexOf()
		String Str = new String("Welcome to google.com");
		String SubStr1 = new String("Tutorials");
		String SubStr2 = new String("Sutorials");
		System.out.println("indexOf('o'):" + Str.indexOf('o'));// indexOf('o'):4
		System.out.println("indexOf('o', 5):" + Str.indexOf('o', 5));// indexOf('o', 5):9
		// str the substring to search for.fromIndex the index from which to start the
		// search.
		int index = Str.indexOf("google", 10); // Str.indexOf("google", 12); o/p -1
		System.out.println("index of substring " + index);
		System.out.println(Str.charAt(11));
		System.out.println("indexOf(SubStr1):" + Str.indexOf(SubStr1));// indexOf(SubStr1):-1
		System.out.println("indexOf(SubStr1, 15):" + Str.indexOf(SubStr1, 15));// indexOf(SubStr1, 15):-1
		System.out.println("indexOf(SubStr2):" + Str.indexOf(SubStr2));// indexOf(SubStr2):-1
		// replace() 
		String StrT = new String("Welcome to google.com");
		System.out.println("replace('o', 'T'):" + StrT.replace('o', 'T'));// replace('o', 'T'):WelcTme tT gTTgle.cTm
		// replaceAll()
		String StrR = new String("Welcome to googleGO.com");
		// replaceAll("(.*)google(.*)", "money"): money
		System.out.println("replaceAll(\"(.*)google(.*)\", \"money\"): " + StrR.replaceAll("(.*)google(.*)", "money"));
		// equals
		String z1 = "javatpoint";
		String z2 = "javatpoint";
		String z3 = "JAVATPOINT";
		String z4 = "python";
		System.out.println(z1.equals(z2));// true because content and case is same
		System.out.println(z1.equals(z3));// false because case is not same
		System.out.println(z1.equals(z4));// false because content is not same
		DemoTest d = new DemoTest(1, "a");
		DemoTest d1 = new DemoTest(1, "a");
		System.out.println(d.equals(d1));// will be true if equals(Object obj) is overridden else false.
		System.out.println(d == d1);
		// equalsIgnoreCase
		String sss1 = "javatpoint";
		String sss2 = "javatpoint";
		String sss3 = "JAVATPOINT";
		String sss4 = "python";
		System.out.println(sss1.equalsIgnoreCase(sss2));// true because content and case both are same
		System.out.println(sss1.equalsIgnoreCase(sss3));// true because case is ignored
		System.out.println(sss1.equalsIgnoreCase(sss4));// false because content is not same
		// getBytes it returns sequence of bytes.
		String x1 = "ABCDEFG";
		byte[] barr = x1.getBytes();
		for (int i = 0; i < barr.length; i++) {
			System.out.println(barr[i]);
		}
		// Getting string back
		String x2 = new String(barr);
		System.out.println(x2);
		// getChars getChars(int srcBeginIndex, int srcEndIndex, char[] destination, int
		// dstBeginIndex)
		String c = new String("hello people how r u");
		char[] ch = new char[10];
		c.getChars(6, 16, ch, 0);
		System.out.println(ch);// people how
		// intern
		String intern = new String("hello");
		String intern2 = "hello";
		String intern3 = intern.intern();// returns string from pool, now it will be same as s2
		System.out.println(intern == intern2);// false because reference variables are pointing to different instance
		System.out.println(intern2 == intern3);// true because reference variables are pointing to same instance
		// empty It returns true, if length of string is 0
		String empty = "";
		String empty2 = "javatpoint";
		System.out.println(empty.isEmpty()); // true
		System.out.println(empty2.isEmpty()); // false
		// join
		String date = String.join("/", "25", "06", "2018"); // 25/06/2018
		System.out.println(date);
		String joinString1 = String.join("-", "welcome", "to", "india"); // welcome-to-india
		System.out.println(joinString1);
		// lastIndexOf
		String lastInd = "abc abbbcccc ddddddaaa abac";
		int index1 = lastInd.lastIndexOf('a');
		System.out.println(index1); // 25 last index length-1
		String lastIndex = "1abcdefghijklabcqwertyde";
		int lastInde = lastIndex.lastIndexOf("ab", 10);// 0-10 if any ab present
		System.out.println(lastInde);
		// length
		String length = "java";
		String emptyLength = "";
		System.out.println("string length is: " + length.length());// 4
		System.out.println("string length is: " + emptyLength.length());// 0
		// replace
		String replace = "java is platform independent";
		String replaceString = replace.replace('a', 'e');// replaces all occurrences of 'a' to 'e'
		System.out.println(replaceString);
		String replace1 = "this is good that is bad";
		String replaceString1 = replace1.replace("is", "was");// replaces all occurrences of "is" to "was"
		System.out.println(replaceString1);
		// replaceAll
		String replaceAll = "hello Bond james Bond";
		String replaceAllString = replaceAll.replaceAll("\\s", "");
		System.out.println(replaceAllString);
		// startsWith
		String startsWith = "java string split method";
		System.out.println(startsWith.startsWith("ja"));
		System.out.println(startsWith.startsWith("java string"));
		String startsWith1 = "Javatprogram";
		System.out.println(startsWith1.startsWith("J")); // True
		System.out.println(startsWith1.startsWith("a")); // False
		System.out.println(startsWith1.startsWith("a", 1)); // True
		// substring
		String substring = "javaprogram";
		System.out.println(substring.substring(2, 4));// returns va
		System.out.println(substring.substring(2));// returns vaprogram
		// toCharArray
		String charArr = "hello";
		char[] toCharArray = charArr.toCharArray();
		for (int i = 0; i < toCharArray.length; i++) {
			System.out.print(ch[i]);
		}
		// toLowerCase,toUpperCase
		String toLowerCase = "String lower case test";
		String eng = toLowerCase.toLowerCase(Locale.ENGLISH);
		System.out.println(eng);
		String turkish = toLowerCase.toLowerCase(Locale.forLanguageTag("tr")); // It shows i without dot
		System.out.println(turkish);
		// trim() method eliminates leading and trailing spaces
		String trim = "  java trim test   ";
		System.out.println(trim.trim());
		// valueOf() method converts different types of values into string
		float valueOff = 10.05f;
		double valueOfd = 10.02;
		String valOf1 = String.valueOf(valueOff);
		String valOf2 = String.valueOf(valueOfd);
		System.out.println(valOf1);
		System.out.println(valOf2);
		// regionMatches
		String regionMatches1 = new String("Hello, How are you");
		String regionMatches2 = new String("How");
		String regionMatches3 = new String("HOW");
		System.out.println(regionMatches1.regionMatches(7, regionMatches2, 0, 3));// true
		System.out.println(regionMatches1.regionMatches(7, regionMatches3, 0, 3)); // false
		System.out.println(regionMatches1.regionMatches(true, 7, regionMatches3, 0, 3));// true
		//matches
		String matches = new String("java for java people");
		System.out.print("Does String contains regex (.*)java(.*) ? : ");
		System.out.println(matches.matches("(.*)java(.*)"));
		System.out.print("Does String contains regex java ? : ");
		System.out.println(matches.matches("java"));
		short shortValue = 1; 
		String stringValue = "" + shortValue;
		System.out.println("stringValue :"+stringValue);
		short shortt = Short.parseShort("1");
		System.out.println("shortt :"+shortt);
		double doubleValue = 1;
		String stringDoubleValue = "" + doubleValue; 
		System.out.println("stringDoubleValue :"+stringDoubleValue);

	}

}

class DemoTest {
	int a;
	String b;

	public DemoTest() {
	}

	public DemoTest(int a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoTest other = (DemoTest) obj;
		if (a != other.a)
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

}
