package com.sample.java.stream;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefBasic {
	public static void main(String[] args) {

		// Static Method Reference
		Function<String, Integer> parseInt = Integer::parseInt;
		Integer number = parseInt.apply("123");
		System.out.println(number); // Output: 123

		// Instance Method Reference of a Particular Object
		String str = "Hello, World!";
		Supplier<Integer> lengthSupplier = str::length;
		Integer length = lengthSupplier.get();
		System.out.println(length); // Output: 13

		// Instance Method Reference of an Arbitrary Object of a Particular Type
		Function<String, String> toUpperCase = String::toUpperCase;
		String result = toUpperCase.apply("hello");
		System.out.println(result); // Output: HELLO

		// Constructor Reference
		Supplier<MethodRefBasic> exampleSupplier = MethodRefBasic::new;
		MethodRefBasic example = exampleSupplier.get();
		System.out.println(example); // Output: MethodReferenceExample@<hashcode>
		
		//Reference to an Instance Method of an Arbitrary Object of a Particular Type
		Perso p=new Perso("RAM",21);
        Function<Perso, Integer> getAge = Perso::getAge;
        Function<Perso, String> getName = Perso::getName;
        System.out.println("Name:"+getName.apply(p)+" Age:"+getAge.apply(p));

        Function<Perso, String> getPersonInfo = Perso::getPersonInfo;
        System.out.println(getPersonInfo.apply(p));

        BiFunction<Perso, String, String> greetPerson = Perso::greetPerson;
        System.out.println(greetPerson.apply(p, "Hello"));


        // Using method reference to find max
        BiFunction<Integer, Integer, Integer> findMax = MathUtils::findMax;
        System.out.println("Max of 10 and 20: " + findMax.apply(10, 20));
	}

}

class Perso {
    private String name;
    private int age;

    public Perso(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonInfo() {
        return "Name: " + name + ", Age: " + age;
    }

    // New parameterized method
    public String greetPerson(String greeting) {
        return greeting + ", " + name;
    }
}

class MathUtils {
    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }
}
