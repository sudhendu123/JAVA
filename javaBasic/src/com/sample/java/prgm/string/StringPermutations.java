package com.sample.java.prgm.string;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public static Set<String> getPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);
        String remainingString = str.substring(1);
        Set<String> words = getPermutations(remainingString);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String permutation = insertCharAt(word, firstChar, i);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        String input = "abc";
        Set<String> permutations = getPermutations(input);
        System.out.println("Permutations of " + input + ": " + permutations);
    }
}    