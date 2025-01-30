package com.sample.java.prgm.string;

public class StringCombinations {


    // Function to print all the permutations of the given string
    public static void printPermutations(String str) {
        permute(str, 0, str.length() - 1);
    }

    // Helper function to generate permutations
    private static void permute(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right);
                str = swap(str, left, i); // backtrack
            }
        }
    }

    // Function to swap characters at position i and j in a string
    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("All permutations of the string \"" + str + "\":");
        printPermutations(str);
    }

}
