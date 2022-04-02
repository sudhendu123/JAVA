package com.sample.java.collection;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("db.properties");

		Properties p = new Properties();
		p.load(reader);

		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("password"));

		Properties pop = System.getProperties();
		Set set = pop.entrySet();

		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		Properties po=new Properties();  
		po.setProperty("name","Sonoo Jaiswal");  
		po.setProperty("email","sonoojaiswal@javatpoint.com");  
		  
		po.store(new FileWriter("info.properties"),"Javatpoint Properties Example");  
	}
}
