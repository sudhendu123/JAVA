package com.sample.java.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialNDeserialTest {

	public static void main(String args[]) {
		try {
			// Creating the object
			Student s1 = new Student(211, "ravi");
			// Creating stream and writing the object
			FileOutputStream fout = new FileOutputStream("f.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			out.flush();
			// closing the stream
			out.close();
			System.out.println("Deserialization ");

			// Creating stream to read the object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
			Student s = (Student) in.readObject();
			// printing the data of the serialized object
			System.out.println(s.id + " " + s.name);
			// closing the stream
			in.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8201913101823322084L;
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}