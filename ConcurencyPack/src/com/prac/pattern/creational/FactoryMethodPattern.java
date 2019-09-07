package com.prac.pattern.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author sudhendu.kumar
 *The Factory Method Pattern is also known as Virtual Constructor.
 *Factory Method Pattern says that just define an interface
 * or abstract class for creating an object but let the subclasses decide which class to instantiate.
 */
public class FactoryMethodPattern {

    public static void main(String args[])throws IOException {
        GetPlanFactory planFactory = new GetPlanFactory();

        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String planName=br.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);
        //call getRate() method and calculateBill()method of DomesticPaln.

        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}

abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println("main plan");
        System.out.println(units*rate);
    }
}

class  DomesticPlan extends Plan{
    //@override
    public void getRate(){
        rate=3.50;
    }
}

class  CommercialPlan extends Plan {
    //@override
    public void getRate() {
        rate = 7.50;
    }

    public void calculateBill(int units){
        System.out.println("CommercialPlan plan");
        System.out.println(units*rate);
    }
}

class  InstitutionalPlan extends Plan {
    //@override
    public void getRate() {
        rate = 5.50;
    }
}

class GetPlanFactory{

    //use getPlan method to get object of type Plan
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        }
        else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}



