


package divideandconquer;

import java.util.Scanner;

public class SkyLineBruteForce {
    public static void main(String[] args) {
        int[] auxHeights = new int[1000];
        int rightMostBuildingRi = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int left = in.nextInt(), h = in.nextInt(), right = in.nextInt();
            for (int i = left; i < right; i++)
                auxHeights[i] = Math.max(h, auxHeights[i]);
            if(rightMostBuildingRi<right)
            	rightMostBuildingRi=right;	
        }
        int prev=0, left=-1, right = -1;
        for (int i = 0; i < rightMostBuildingRi; i++) {
            if (prev != auxHeights[i]) {
                if(left > 0) System.out.print(left +" "+ right + " ");
                prev = auxHeights[i];
                left =i;
                right =prev;
            }
        }
        System.out.println(left +" "+ right );
    }
}