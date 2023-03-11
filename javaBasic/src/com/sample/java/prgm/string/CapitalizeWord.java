package com.sample.java.prgm.string;

public class CapitalizeWord {
	public static void main(String[] args) {
		System.out.println(CapitalizeWord.capitalizeWord("first letter of the word is capital."));
		CapitalizeWord.changecase("abc HELLO");
		System.out.println("");
		CapitalizeWord.toLowerIfupperPresent("abc HELLO");
		CapitalizeWord.toUpperIfLowerPresent("abc");
		CapitalizeWord.toLower("ASDF WER qty");
		CapitalizeWord.toUpper("asdf gh jkl");
	}

	public static String capitalizeWord(String str) {
		String words[] = str.split("\\s");
		String capitalizeWord = "";
		for (String w : words) {
			String first = w.substring(0, 1);
			String afterfirst = w.substring(1);
			capitalizeWord += first.toUpperCase() + afterfirst + " ";
		}
		return capitalizeWord.trim();
	}

	// ASCII for A=65,Z=90 and a=97,z=122 space=32
	//A=65+32=97 which is small a , 32 is the difference between upper and lower case
	public static void changecase(String s) {
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			if (ch > 64 && ch < 91) {
				ch = ch + 32;
				System.out.print((char) ch);
			} else if (ch > 96 && ch < 123) {
				ch = ch - 32;
				System.out.print((char) ch);
			}
			if (ch == 32)
				System.out.print(" ");
		}
	}

	public static void toLowerIfupperPresent(String s) {
		char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			if (ch > 64 && ch < 91) {
				ch = ch + 32;
				arr[i] = (char) ch;
			}
		}
		System.out.println(new String(arr));
	}

	public static void toUpperIfLowerPresent(String s) {
		char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			if (ch > 96 && ch < 123) {
				ch = ch - 32;
				arr[i] = (char) ch;
			}
		}
		System.out.println(new String(arr));
	}

	public static void toLower(String s) {
		char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			ch = ch + 32;
			arr[i] = (char) ch;
		}
		System.out.println(new String(arr));
	}

	public static void toUpper(String s) {
		char arr[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			ch = ch - 32;
			arr[i] = (char) ch;
		}
		System.out.println(new String(arr));
	}

}
