

package array;

public class SingleDimArray {
	
	public static void main(String[] args) {
		single();
		single2();
		single3();
		single4();
	}
	
	public static void single() {
		int a[]=new int[10];
		a[0]=1;
		a[1]=2;
		for(int b:a) {
			System.out.println("a[] "+b);
		}
		System.out.println("1st index :"+a[1]);
		
	}
	
	//Array Literal
	public static void single2() {
		int a[]={33,3,4,5};//declaration, instantiation and initialization  
		//printing array  
		for(int i=0;i<a.length;i++)//length is the property of array  
		System.out.println(a[i]);
		
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
	}
	
	public static void single3() {
		//array object
		Account obj[] = new Account[3] ;
	    obj[0] = new Account();
	    obj[1] = new Account();
	    obj[0].setData(1,2);
	    obj[1].setData(3,4);
	    System.out.println("For Array Element 0");
	    obj[0].showData();
	    System.out.println("For Array Element 1");
	    obj[1].showData();
	    
	    obj[2] = new Account(5,6);
	    System.out.println("For Array Element 2");
	    obj[2].showData();
	}
	
	public static void single4() {
		int intArray[] = new int[3]; 
        byte byteArray[] = new byte[3]; 
        short shortsArray[] = new short[3]; 
          
        // array of Strings 
        String[] strArray = new String[3]; 
          
        System.out.println(intArray.getClass()); 
        System.out.println(intArray.getClass().getSuperclass()); 
        System.out.println(byteArray.getClass()); 
        System.out.println(shortsArray.getClass()); 
        System.out.println(strArray.getClass()); 
	}
	

}

class Account{
	  int a;
	  int b;
	  
	 public Account() {}
	 
	 public Account(int a,int b) {
		 this.a=a;
		 this.b=b;
	 }
	 
	 public void setData(int c,int d){
	   a=c;
	   b=d;
	 }
	 public void showData(){
	   System.out.println("Value of a ="+a);
	   System.out.println("Value of b ="+b);
	 }
	}
