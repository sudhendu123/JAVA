package com.sample.java.innerclass;

public class MethodLocalInnerCLass {

	private int data = 30;// instance variable

	void display() {
		class Local {
			void msg() {
				System.out.println(data);
			}
		}
		Local l = new Local();
		l.msg();
	}

	public static void main(String args[]) {
		MethodLocalInnerCLass obj = new MethodLocalInnerCLass();
		obj.display();
	}

}
