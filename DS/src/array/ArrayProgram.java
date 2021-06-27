package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProgram {
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 3, 15, 10, 2};
		ArrayProgram ma = new ArrayProgram();
		System.out.println("min = "+ma.findMinimum(arr));
		//reverse
		int rev[]=ma.reverseArr(arr);
		for(int i=0;i<rev.length;i++) {
			System.out.print(rev[i]+", ");
		}
		//pallindrome
		System.out.println("");
		int pall[] = { 1, 2, 0, 2, 1 };
		palindrome(pall);
		String strArr[]= {"m","a","m"};
		stringPalindrome(strArr);
		//max
		System.out.println("second max:"+findMax(arr, 1));
		//sum of 2 numbers
		int[] numbers = {2, 11, 5, 10, 7, 8};
		int[] result = twoSum(numbers, 9);
		System.out.println("The two indices are - " + result[0] + 
                                   " and " + result[1]);
		
	}

	public int findMinimum(int a[]) {
		int min=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]<min) {
				min=a[i];
			}
		}
		return min;
	}
	
	public static int findMax(int a[],int pos) {
		int max=a[0];
		int maxPos = 0;
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				maxPos=i;
			}
		}
		return a[maxPos-pos];
	}
	
	public int[] reverseArr(int a[]) {
		int n=a.length;
		int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
		return b;
	}
	
	public static void palindrome(int arr[])
    {
		int n=arr.length;
        // Initialise flag to zero.
        int flag = 0;
 
        // Loop till array size n/2.
        for (int i = 0; i <= n / 2 && n != 0; i++) {
 
            // Check if first and last element are different
            // Then set flag to 1.
            if (arr[i] != arr[n - i - 1]) {
                flag = 1;
                break;
            }
        }
 
        // If flag is set then print Not Palindrome
        // else print Palindrome.
        if (flag == 1)
            System.out.println("Not Palindrome");
        else
            System.out.println("Palindrome");
    }
	
	public static void stringPalindrome(String sarr[])
    {
		int n=sarr.length;
		String[] revArr = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
        	revArr[j - 1] = sarr[i];
            j = j - 1;
        }
        /**
        for (int i = 0; i < n / 2; i++) {
            String temp = sarr[i];
            sarr[i] = sarr[n-i-1];
            sarr[n-i-1] = temp;
         }
         */
        
        if(Arrays.equals(revArr, sarr)) {
            System.out.println("Entered string is a palindrome");
         } else {
            System.out.println("Entered string is not a palindrome");
         }
    }
	
	public static int[] twoSum(int[] numbers, int target) {
		//array={2, 11, 5, 10, 7, 8} target=9
		//res =arr[0]+a[4]=2+7=9 return 0,4
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++) {
		    if(!map.containsKey(target - numbers[i])) {
			   map.put(numbers[i], i);
		    } else {
		         result[1] = i;
		         result[0] = map.get(target - numbers[i]);
		         return result;   
		    }
		}
		throw new IllegalArgumentException("Two numbers not found");
	}
}
