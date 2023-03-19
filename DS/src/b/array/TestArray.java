package b.array;

public class TestArray {
	
	public static void main(String[] args) {
		int a[]= {56,7,6,11,2,3,1,4};
		
		//find min
		int j=a.length;
		int b[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			b[j-1]=a[i];
			j=j-1;
		}
		
		for(int c:b) {
			System.out.println(c);
		}
		reverse(b, 0, a.length-1);
		System.out.println("====");
		for(int c:b) {
			System.out.println(c);
		}
	}
	
	public static void reverse(int[] numbers, int start, int end) {
		while(start < end) {
			int temp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = temp;
			start++;
			end--;
		}
	}

}
