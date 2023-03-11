package com.sample.java.prgm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Sample {
	public static void ss(List<String> ss) {
		
	}
	
	public static String getBitFromDecimalRecord(String groupRecordingFs) {
    
		return String.format("%3s", Integer.toBinaryString(Integer.parseInt(groupRecordingFs))).replace(" ", "0");
    }
	
	public static void main(String[] args) {
		
		String res = getBitFromDecimalRecord("2");
		System.out.println("res: "+res);
		
		Collection<Empl> db=new ArrayList<>();
		db.add(new Empl(1,"na",20,"2000"));
		db.add(new Empl(2,"na1",21,"2001"));
		db.add(new Empl(3,"na2",22,"2002"));
		
		
		Collection<Empl> req=new ArrayList<>();
		req.add(new Empl(4,"na3",23,"2003"));
		req.add(new Empl(3,"na2",22,"2002"));
		
		//insert
		List<Integer> req1=new ArrayList<>();
		req1.add(3);
		
		req.removeIf(s -> req1.contains(s.getId()));
		System.out.println("db :"+req);
		
		Collection<Empl> insert=new ArrayList<>(req);
		insert.removeAll(db);
		System.out.println(" insert :"+insert);
		
		Set<String> targetMdnSet =new HashSet<>();
		targetMdnSet.add("12");
		targetMdnSet.add("34");
		
		Collection<String> disabledPttVideoFeatureList=new ArrayList<>();
		disabledPttVideoFeatureList.add("12");
		
		
		
		BitSet clientFS_BitSet = convertHexStringToBitSet("FC3DC301729B23EFBEC2050C04FFD8C33");
		BitSet subsFS_BiSet = convertHexStringToBitSet("3FC23CFBF12FFFFFFFBFDDFFDF6FFFD57F");
		BitSet opsFS_BiSet = convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		BitSet confFS_BitSet =convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		BitSet license_BitSet = convertBinStringToBitSet("1111111111111011111111111111111111111011111111111111111111111111111111111111111111111111111101111111111111111111111111111111111111100");
		//BitSet license_BitSet = convertBinStringToBitSet("0b11111111111110111111000000011111111100111011011111111111111111111111111111111111100111011111111101111110111101000111111101111111111111");
		//BitSet license_BitSet =convertHexStringToBitSet("3FFEFC07FCEDFFFFFFFFE77FDFBD1FDFFF");
		System.out.println(" license_BitSet :"+license_BitSet);
		BitSet xdmsFS_BiSet = convertHexStringToBitSet("3FFFFFFFFFEFFFFFFFFFFFFFDFF7FFDFF7");
		
		BitSet activeFS_BitSet = new BitSet(Long.SIZE);
		activeFS_BitSet.or(license_BitSet);
		activeFS_BitSet.and(clientFS_BitSet);
		activeFS_BitSet.and(subsFS_BiSet);
		activeFS_BitSet.and(confFS_BitSet);
		activeFS_BitSet.and(opsFS_BiSet);
		activeFS_BitSet.and(xdmsFS_BiSet);
		
		BitSet corpFS_BitSet = convertHexStringToBitSet("383EFC07FCEFFFFFFFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(corpFS_BitSet);
		BitSet corpAdminFS_BitSet = convertHexStringToBitSet("383FFCFFFFEFEFFFBFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(corpAdminFS_BitSet);
		BitSet userProfileFS_BiSet = convertHexStringToBitSet("3FFFFCFFFFEFFFFFFFFFFFFFDFFFFFDFFF");
		activeFS_BitSet.and(userProfileFS_BiSet);
		
		BitSet clientCapabilityOverrideFS_BiSet = convertHexStringToBitSet("3FFFFFFFFFEFFFFFFFFFE7FFDF7FFFDFFF");
		activeFS_BitSet.and(clientCapabilityOverrideFS_BiSet);
		System.out.println("activeFS_BitSet 1"+activeFS_BitSet);
		String activeFeatureSet = convertBitSetToHexString(activeFS_BitSet);
		
		System.out.println("activeFeatureSet 1"+activeFeatureSet);
		
		
		System.out.println(convertBitSetToHexString(activeFS_BitSet));
		
		
		
		revrese("abcc heba");
		System.out.println(reverseStringChar("qwe rt"));
		
		Map<Integer, Integer> groupEtagMap = new HashMap<Integer, Integer>();
		System.out.println("group = "+groupEtagMap.isEmpty());
	}
	
	public static BitSet convertBinStringToBitSet(String value) {
		String methodName = "convertBinStringToBitSet(String)";
		BitSet bitSet = new BitSet(value.length());
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '1') {
				bitSet.set(i);
			}
		}
		return bitSet;
	}


	public static void revrese(String str) {
	
		
		List<String> mcDataIds =new java.util.ArrayList<String>();
		mcDataIds.add("tel:+918861818");
		mcDataIds.add("sip:+918861716");
		mcDataIds.add("918861819");
		mcDataIds.add("918861820");
		
		String userScheme="sip";
		String colon=":";
		String at="@";
		String userDomain="domain";
		
		
		List<String> mcdataNew = mcDataIds.stream().filter(q->!q.contains(":")).collect(Collectors.toList());
		mcDataIds.removeAll(mcdataNew);
		
		System.out.println("mcDataIds"+mcDataIds);
		//<MCX_USER_SCHEME>+":"+<name>+"@"<MCX_USER_DOMAIN>
		List<String> newmcdataNew=new ArrayList<String>();
		List<String> newmcdataNeww=new ArrayList<String>();
		
		for(String strr:mcdataNew) {
			newmcdataNew.add(new StringBuilder()
					.append(userScheme)
					.append(colon)
					.append(strr)
					.append(at)
					.append(userDomain)
					.toString());
			
			newmcdataNeww.add(new String(userScheme+colon+strr+at+userDomain));
		}
		
		newmcdataNeww.addAll(mcDataIds);
		
		System.out.println(mcdataNew);
		System.out.println(newmcdataNew);
		System.out.println(newmcdataNeww);
	}
	
	public static String reverseStringChar(String str) {
		char ch[] = str.toCharArray();
		String rev = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			rev += ch[i];
		}
		return rev;
	}
	
	public static BitSet convertHexStringToBitSet(String hexString) {
		String bin = new BigInteger(hexString, 16).toString(2);
		BitSet bitSet = new BitSet(bin.length());
		for (int i = 0; i < bin.length(); i++) {
			boolean value = bin.charAt(i) == '1' ? true : false;
			bitSet.set(bin.length() - 1 - i, value);
		}

		return bitSet;

	}
	
	public static String convertBitSetToHexString(BitSet bitSet) {
		String hexString = new BigInteger(convertBitSetToBinString(bitSet), 2).toString(16).toUpperCase();
		return hexString;
	}
	
	public static String convertBitSetToBinString(BitSet bitSet) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < bitSet.size(); i++) {
			if (bitSet.get(i)) {
				buffer.append("1");
			} else {
				buffer.append("0");
			}
		}
		String binString = buffer.reverse().toString();
		return binString;
	}

}

class Empl {

	int id;
	String name;
	int age;
	String sal;

	public Empl() {
	}

	public Empl(int id, String name, int age, String sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "empl [id=" + id + ", name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sal == null) ? 0 : sal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empl other = (Empl) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sal == null) {
			if (other.sal != null)
				return false;
		} else if (!sal.equals(other.sal))
			return false;
		return true;
	}

}