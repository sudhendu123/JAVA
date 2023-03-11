package com.sample.java.basic;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ExternalizationDemo {
	 
    private String filePath = "user.ser";
 
    public void serialize() throws IOException {
        User user = new User();
 
        user.setCode(123);
        user.setName("Tom");
        user.setBirthday(new Date());
        user.setPassword("secret123");
        user.setSocialSecurityNumber(1234567890);
 
 
        // serialize object's state
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(user);
        outputStream.close();
 
 
        System.out.println("User's details before serialization:\n" + user);
        System.out.println("Serialization done");
    }
 
    public void deserialize() throws ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        User user = (User) inputStream.readObject();
        inputStream.close();
 
        System.out.println("User's details afeter de-serialization:\n" + user);
    }
 
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        ExternalizationDemo demo = new ExternalizationDemo();
 
        demo.serialize();
 
        System.out.println("\n=============\n");
 
        demo.deserialize();
 
    }
 
}

class User implements Externalizable {
	
	//The serialization at runtime associates with each serializable class a version number called a serialVersionUID,
	//which is used during deserialization to verify that the sender and receiver of a 
	//serialized object have loaded classes for that object that are compatible with respect to serialization.
    public static final long serialVersionUID = 1234L;
 
    // attributes
    private int code;
    private String name;
    private String password;
    private Date birthday;
    private int socialSecurityNumber;
 
    public User() {
    }
 
    // methods (getters and setters)
    public int getCode() {
        return this.code;
    }
 
    public void setCode(int code) {
        this.code = code;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return this.password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
 
    public Date getBirthday() {
        return this.birthday;
    }
 
    public void setSocialSecurityNumber(int ssn) {
        this.socialSecurityNumber = ssn;
    }
 
    public int getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(code);
	    out.writeObject(name);
	 
	    // write empty password:
	    out.writeObject("");
	 
	    out.writeObject(birthday);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.code = in.readInt();
	    this.name = (String) in.readObject();
	    this.password = (String) in.readObject();
	    this.birthday = (Date) in.readObject();
	}
	
	public String toString() {
	    String details = "Code: " + code;
	    details += "\nName: " + name;
	    details += "\nBirthday: " + birthday;
	    details += "\nPassword: " + password;
	    details += "\nSSN: " + socialSecurityNumber;
	 
	    return details;
	}
}