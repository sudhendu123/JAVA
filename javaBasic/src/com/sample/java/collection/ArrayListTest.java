package com.sample.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ArrayListTest {

	public static void main(String[] args) {
		List<String> nullList=new ArrayList();
		/**
		 * 
		 
		nullList.add(null);
		nullList.add("2");
		nullList.add(null);
		nullList.add("3");
		nullList.add(null);
		*/
		System.out.println(" nullList :"+nullList);
		nullList.removeAll(Collections.singleton(null));
		System.out.println(" nullList removed null :"+nullList);
		
		List<String> arrayConvert=new ArrayList();
		String[] y = arrayConvert.toArray(new String[0]);
		
		Set<String> set1 =null; 
		System.out.println("set1 "+set1);
		List<String> list1 = new ArrayList<>();
		if(set1!=null&&!set1.isEmpty())
		list1.addAll(set1);
		System.out.println(" list1 "+list1);
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("def");
		list.add("ghi");
		list.add(1, "sdf");
		

		list.remove(1);
		list.removeIf(q->q.contains("abc"));
		list.remove("abc");

		list.set(1, "replaced");

		System.out.println(list.get(1));
		System.out.println(list.indexOf("abcs"));
		System.out.println(list.size());
		System.out.println(list.contains("def"));
		list.clear();
		System.out.println("empty list: " + list);
		list.add("qwe");
		// initialization
		ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5));
		System.out.println("ArrayList items copy: " + intlist);

		ArrayList<String> cities = new ArrayList<>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("Delhi");
				add("Agra");
				add("Chennai");
			}
		};
		System.out.println("Content of Array list cities:" + cities);
		// iterate over empty string
		ArrayList<String> obj1 = new ArrayList<>();
		for (String s : obj1) {
			System.out.println("empty");
		}
		System.out.println("didn't enter");
		ArrayList<String> obj = new ArrayList<String>(Arrays.asList("Pratap", "Peter", "Harsh"));
		System.out.println("Elements are:" + obj);
		// adding or merging list
		obj.addAll(cities);
		System.out.println("added cities to name" + obj);
		obj.addAll(2, list);
		System.out.println("added list at index" + obj);
		obj.add(1, "Delhi");
		System.out.println(obj + "last index of Delhi :" + obj.lastIndexOf("Delhi"));

		List<String> syncal = Collections.synchronizedList(obj);
		System.out.println("synchronized colection" + syncal);

		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<String>();

		Collections.swap(obj, 1, 4);
		System.out.println("after swap" + obj);
		ArrayList<String> al2 = (ArrayList<String>) obj.clone();
		System.out.println("Shallow copy of ArrayList: " + al2);
		obj.trimToSize();
		// Increase capacity to 5
		obj.ensureCapacity(5);
		/* ArrayList to Array Conversion */
		String objj[] = obj.toArray(new String[obj.size()]);
		// sublisting
		List<String> subsList = obj.subList(1, 4);
		System.out.println("sub list" + subsList);
		// loop ArrayList
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(14);
		arrlist.add(7);
		arrlist.add(39);
		arrlist.add(40);

		/* ArrayList to Array Conversion */
		String stringArray[] = obj.toArray(new String[obj.size()]);
		List<String> arraysAslIst = Arrays.asList(stringArray);
		/* For Loop for iterating ArrayList */
		System.out.println("For Loop");
		for (int counter = 0; counter < arrlist.size(); counter++) {
			System.out.println(arrlist.get(counter));
		}

		/* Advanced For Loop */
		System.out.println("Advanced For Loop");
		for (Integer num : arrlist) {
			System.out.println(num);
		}

		/* While Loop for iterating ArrayList */
		System.out.println("While Loop");
		int count = 0;
		while (arrlist.size() > count) {
			System.out.println(arrlist.get(count));
			count++;
		}

		/* Looping Array List using Iterator */
		System.out.println("Iterator");
		Iterator<Integer> iter = arrlist.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// enumeration
		System.out.println("enumerate");
		Enumeration<Integer> enumerat = Collections.enumeration(arrlist);
		while (enumerat.hasMoreElements()) {
			System.out.println(enumerat.nextElement());
		}

		ArrayList<Empl> empList = new ArrayList<>();
		empList.add(new Empl(1, "abc", 24, "10000"));
		empList.add(new Empl(2, "abc2", 22, "20000"));
		empList.add(new Empl(3, "abc3", 23, "30000"));
		empList.add(new Empl(4, "abc2", 24, "4000"));
		empList.add(new Empl(5, "abc2", 24, "4000"));
		empList.add(new Empl(6, "abc6", 24, "4000"));
		empList.add(new Empl(1, "abc", 24, "10000"));

		ArrayList<Empl> empList12 = new ArrayList<>();
		empList12.add(new Empl(1, "abc", 24, "10000"));
		empList12.add(new Empl(2, "abc2", 22, "20000"));
		empList12.add(new Empl(3, "abc3", 23, "30000"));
		empList12.add(new Empl(7, "abc4", 23, "30000"));
		//convert list to linked list
		LinkedList<String> nameLinkedList = empList12.stream()
		        .map(Empl::getName)
		        .collect(Collectors.toCollection(LinkedList::new));
		System.out.println(" nameLinkedList :"+nameLinkedList);		
		//convert list to map
		Map<Integer, String> mapRes = empList12.stream().collect(Collectors.toMap(Empl::getId, Empl::getName));
		System.out.println("mapRes :"+mapRes.isEmpty());
		//convert dto
		List<Empl1> listDto = new ArrayList<>();
		/**Class<Empl1> type = Empl1.class;
		empList12.forEach(animal -> {
            	Empl1 objAsType = type.cast(animal);
                listDto.add(objAsType);
        });*/
		transformList(empList12, listDto);
		System.out.println("### DTO "+listDto);
		
		
		// empty list removing element
		ArrayList<Empl> empList1 = new ArrayList<>();
		List<Integer> emptyEmp = empList1.stream().map(Empl::getId).collect(Collectors.toList());
		List<Integer> emptyEmp1 = empList1.stream().map(Empl::getId).collect(Collectors.toList());
		emptyEmp1.removeAll(emptyEmp);
		System.out.println("emptyEmp " + emptyEmp);
		List<Integer> idsNotIn = empList.stream().filter(q->q.id!=2).map(Empl::getId).collect(Collectors.toList());
		System.out.println(" idsNotIn :"+idsNotIn);
		// getting only ids
		List<Integer> idslistOne = empList.stream().map(Empl::getId).collect(Collectors.toList());
		System.out.println("idslistOne :"+idslistOne);

		// Compare two arraylists for equality
		List<Integer> idslistTwo = empList12.stream().map(Empl::getId).collect(Collectors.toList());
		System.out.println("idslistTwo :"+idslistTwo);
		// idslistTwo.remove(1);
		Collections.sort(idslistOne);
		Collections.sort(idslistTwo);
		boolean isEqual = idslistTwo.equals(idslistOne); // false
		System.out.println("list equality: " + isEqual);

		
		// find common elements
		//idslistOne.retainAll(idslistTwo);
		//System.out.println("equal elements: " + idslistOne);
		Set<String> db=new HashSet<>();
		db.add("1");
		db.add("2");
		db.add("3");
		
		String mdn="4";
		boolean containEl = db.stream().anyMatch(mdn::contains);
		System.out.println(" containEl :"+containEl);
		
		boolean allMatches = db.stream().allMatch(mdn::contains);
		System.out.println(" allMatches :"+allMatches);
		
		List<Integer> differences = idslistOne.stream()
	            .filter(element -> !idslistTwo.contains(element))
	            .collect(Collectors.toList());
		System.out.println("uequal elements1: " + differences);
		
		List<Integer> differences1 = new ArrayList<>(idslistOne);
		differences1.removeAll(idslistTwo);
		System.out.println("uequal elements2: " + differences1);

		//Unique elements
		List<String> allEmpByName = empList.stream().map(Empl::getName).collect(Collectors.toList());
		System.out.println("allEmpByName :"+allEmpByName);
		Collection<String> uniqueEmpByName =new ArrayList<>(new HashSet<>(allEmpByName));
		System.out.println("uniqueEmpByName :"+uniqueEmpByName);
		
		List<Empl> objUniqueName = empList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Empl::getName)))).stream()
				.collect(Collectors.toList());
		System.out.println("objUniqueName :" + objUniqueName);
		Set<Empl> objUniqueName1 = new HashSet<>(empList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Empl::getName)))));
		System.out.println("objUniqueName1 :" + objUniqueName1);
		
		List<Empl> objUniqueAge = empList.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Empl::getAge)))).stream()
				.collect(Collectors.toList());
		System.out.println("objUniqueAge :" + objUniqueAge);
		// distinct() if impl hashCode and equals
		List<Empl> uniqueList = empList.stream().distinct().collect(Collectors.toList());
		System.out.println("uniqueList :" + uniqueList);

		List<Empl> distinctEmp = empList.stream()
				.collect(Collectors.collectingAndThen(Collectors.toMap(c -> Arrays.asList(c.getName(), c.getAge()),
						Function.identity(), (a, b) -> a, LinkedHashMap::new), m -> new ArrayList<>(m.values())));
		System.out.println("distinctEmp :" + distinctEmp);

		Collection<Empl> nonDuplicatedEmployeesById = empList.stream()
				.<Map<Integer, Empl>>collect(HashMap::new, (m, e) -> m.put(e.getId(), e), Map::putAll).values();

		System.out.println("nonDuplicatedEmployeesById :" + nonDuplicatedEmployeesById);

		Collection<Empl> nonDuplicatedEmployeesByName = empList.stream()
				.<Map<String, Empl>>collect(HashMap::new, (m, e) -> m.put(e.getName(), e), Map::putAll).values();

		System.out.println("nonDuplicatedEmployeesByName :" + nonDuplicatedEmployeesByName);

		// unique by id n age
		Object uniqueIdNAge = empList.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.toMap(x -> Arrays.asList(x.getId(), x.getAge()), x -> x,
								BinaryOperator.minBy(Comparator.comparing(Empl::getId))),
						map -> new ArrayList<>(map.values())));
		System.out.println("uniqueIdNAge :" + uniqueIdNAge);

		// splitting list to chunks
		final List<String> listTest = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
				"N", "O", "P", "X");

		final AtomicInteger counter = new AtomicInteger(0);
		final int size = 5;

		final Collection<List<String>> partitioned = listTest.stream()
				.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size)).values();

		// partitioned.forEach(System.out::println);
		for (List<String> par : partitioned) {
			System.out.println("partitioned " + par);
		}

		// getting element by field
		Empl elementByName = empList.stream().filter(e -> e.getName().equals("abc")).findAny().orElse(null);
		System.out.println("elementByName :" + elementByName);

		List<String> cities1 = Arrays.asList("Milan", "London", "New York", "San Francisco");
		String citiesCommaSeparated = String.join(",", cities1);
		System.out.println("citiesCommaSeparated " + citiesCommaSeparated);
		String citiesCommaSeparated1 = cities.stream().collect(Collectors.joining(","));
		System.out.println("citiesCommaSeparated " + citiesCommaSeparated1);

	}
	
	public static <TSource, TRes> void transformList(List<TSource> sourceList, List<TRes> resultList) {
        if (sourceList.size() > 0) {
            for (TSource obj : sourceList) {
                TRes result = (TRes) obj;
                if (result == null) {
                    System.out.println("error in conversion");
                }
                resultList.add(result);
            }
        }
    }
	
	public void test() {
		/**Function<KnCorpContactDTO, KnCorpGroupMemberDTO> transformUPM
        = new Function<KnCorpContactDTO, KnCorpGroupMemberDTO>() {
    @Override
    public KnCorpGroupMemberDTO apply(KnCorpContactDTO type) {
        KnCorpGroupMemberDTO member = new KnCorpGroupMemberDTO();

        return member;
    }
};
return transformUPM.apply(memberMdn);
 */
	}
	

}
