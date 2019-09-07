package com.prac.pattern.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects
 * @author sudhendu.kumar
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object.
 * Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. 
 *
 */
public class CompositePattern {
	public static void main(String[] args) {
		Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer"); 
        Developer dev2 = new Developer(101, "Vinay Sharma", "Developer"); 
        CompanyDirectory engDirectory = new CompanyDirectory(); 
        engDirectory.addEmployee(dev1); 
        engDirectory.addEmployee(dev2); 
           
        Manager man1 = new Manager(200, "Kushagra Garg", "SEO Manager"); 
        Manager man2 = new Manager(201, "Vikram Sharma ", "Kushagra's Manager"); 
           
        CompanyDirectory accDirectory = new CompanyDirectory(); 
        accDirectory.addEmployee(man1); 
        accDirectory.addEmployee(man2); 
       
        CompanyDirectory directory = new CompanyDirectory(); 
        directory.addEmployee(engDirectory); 
        directory.addEmployee(accDirectory); 
        directory.showEmployeeDetails(); 
	}

}

//A common interface for all employee 
interface Employee 
{ 
 public void showEmployeeDetails(); 
} 

class Developer implements Employee 
{ 
 private String name; 
 private long empId; 
 private String position; 
   
 public Developer(long empId, String name, String position) 
 { 
     // Assign the Employee id, 
     // name and the position 
     this.empId = empId; 
     this.name = name; 
     this.position = position; 
 } 
   
 @Override
 public void showEmployeeDetails()  
 { 
     System.out.println(empId+" " +name+ " " + position ); 
 } 
} 

class Manager implements Employee 
{ 
 private String name; 
 private long empId; 
 private String position; 

 public Manager(long empId, String name, String position) 
 { 
     this.empId = empId; 
     this.name = name; 
     this.position = position; 
 } 
    
 @Override
 public void showEmployeeDetails()  
 { 
     System.out.println(empId+" " +name+ " " + position ); 
 } 
} 

class CompanyDirectory implements Employee 
{ 
    private List<Employee> employeeList = new ArrayList<Employee>(); 
        
    @Override
    public void showEmployeeDetails()  
    { 
        for(Employee emp:employeeList) 
        { 
            emp.showEmployeeDetails(); 
        } 
    } 
        
    public void addEmployee(Employee emp) 
    { 
        employeeList.add(emp); 
    } 
        
    public void removeEmployee(Employee emp) 
    { 
        employeeList.remove(emp); 
    } 
} 