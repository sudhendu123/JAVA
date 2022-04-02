package com.sample.java.basic;

public class DeepCloneCopy {
	
	public static void main(String[] args) {
		DeepDepartment dept1 = new DeepDepartment("1", "A", "AVP");
 
		DeepEmployee emp1 = new DeepEmployee(111, "John", dept1);
 
		DeepEmployee emp2 = null;
 
        try {
            // Creating a clone of emp1 and assigning it to emp2
 
            emp2 = (DeepEmployee) emp1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
 
        // Printing the designation of 'emp1'
 
        System.out.println(emp1.dept.designation); // Output : AVP
 
        // Changing the designation of 'emp2'
 
        emp2.dept.designation = "Director";
 
        // This change will be reflected in original Employee 'emp1'
 
        System.out.println(emp1.dept.designation); // Output : AVP
        
        System.out.println(emp2.dept.designation); // Output : Director
    }

}



class DeepEmployee implements Cloneable {
    int id;
 
    String name;
 
    DeepDepartment dept;
 
    public DeepEmployee(int id, String name, DeepDepartment dept) {
        this.id = id;
 
        this.name = name;
 
        this.dept = dept;
    }
 
    // Overriding clone() method to create a deep copy of an object.
 
    protected Object clone() throws CloneNotSupportedException {
    	DeepEmployee emp = (DeepEmployee) super.clone();
 
        emp.dept = (DeepDepartment) dept.clone();
 
        return emp;
    }
}

class DeepDepartment implements Cloneable{
    String empId;
 
    String grade;
 
    String designation;
 
    public DeepDepartment(String empId, String grade, String designation) {
        this.empId = empId;
 
        this.grade = grade;
 
        this.designation = designation;
    }
    //Default version of clone() method.
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}