

package selectionalgorithms;
public class MedianInTwoSortedArraysTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []A = {2,5,7,9,10,15,20,35};
		int []B = {1,5,7,9,10,30,50,70};
		MedianInTwoSortedArrays m = new MedianInTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(A, B));
	}
}
