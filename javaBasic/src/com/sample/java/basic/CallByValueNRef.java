package com.sample.java.basic;

public class CallByValueNRef {

	public static void main(String args[]) {
		callByValue op = new callByValue();

		System.out.println("before change " + op.data);
		op.change(500);
		System.out.println("after change " + op.data);

		callByRef op1 = new callByRef();

		System.out.println("before change " + op1.data);
		op1.change(op1);// passing object
		System.out.println("after change " + op1.data);
	}
}

class callByValue {
	int data = 50;

	void change(int data) {
		data = data + 100;// changes will be in the local variable only
	}

}

class callByRef {
	int data = 50;

	void change(callByRef op) {
		op.data = op.data + 100;// changes will be in the instance variable
	}

}