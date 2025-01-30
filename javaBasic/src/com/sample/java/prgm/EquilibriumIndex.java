package com.sample.java.prgm;

public class EquilibriumIndex {


    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        int equilibriumIndex = findEquilibriumIndex(A);
        System.out.println(equilibriumIndex);
    }

    public static int findEquilibriumIndex(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum -= A[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += A[i];
        }

        return -1; // No equilibrium index found
    }
}