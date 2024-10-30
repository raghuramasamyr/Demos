package com.example.demo.service;

import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRep {

	public static void main(String[] args) {
		
		
		
		//find first non repeating charector in a string
		String nonRep = "apple";
		String s = nonRep.chars()
		.mapToObj(z -> Character.valueOf((char)z))
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(e -> e.getValue() == 1).map(q-> q.getKey().toString()).findFirst().get();
		System.out.println(s);
		System.out.println("===============================================================================");
		//find employee name starting with A using streamAPI
		List<SaveDet> sve = new LinkedList();
		SaveDet s1 = new SaveDet(1L,"Muruga","male");
		SaveDet s2 = new SaveDet(4L,"As a Raghu","male");
		SaveDet s4 = new SaveDet(4L,"As a Raghu","male");
		SaveDet s3 = new SaveDet(2L,"Navi","female");
		sve.add(s1);sve.add(s2);sve.add(s3);sve.add(s4);
		
		List<SaveDet> sveWithA = sve.stream().filter(sa -> sa.getName().startsWith("A")).collect(Collectors.toList());
		sveWithA.stream().forEach(sss -> System.out.println(sss.getName()));
		System.out.println("===============================================================================");
		
		//merge two list and sort by id using java 8
		List<SaveDet> sve2 = new LinkedList();
		SaveDet s11 = new SaveDet(56L,"Muruga","male");
		SaveDet s22 = new SaveDet(12L,"As a Raghu","male");
		SaveDet s33 = new SaveDet(23L,"BS a Navi","female");
		sve2.add(s11);sve2.add(s22);sve2.add(s33);

		Stream.concat(sve.stream(), sve2.stream()).sorted(Comparator.comparing(SaveDet::getId).reversed()).
				forEach(as -> System.out.println(as.getId()));
		System.out.println("===============================================================================");
		
		//find even  number and sum of it
		List<Integer> evenNumber = Arrays.asList(1,2,3,4,5,6);
		
		Integer sumOfEvenNumbers = evenNumber.stream().filter(sd -> (sd % 2) ==0)
				.mapToInt(Integer::intValue).sum();
		System.out.println(sumOfEvenNumbers);
		System.out.println("===============================================================================");
		
		//sort by name and id
		/*Primary Sort by First Name: The list is sorted alphabetically by the firstName field. This means that all entries will be arranged from 'A' to 'Z' based on their first names.
		  Secondary Sort by Age: If two or more employees have the same first name, they will then be sorted by the age field in ascending order.*/
		
	List<SaveDet> sds = 	Stream.concat(sve.stream(), sve2.stream())
				.sorted(Comparator.comparing(SaveDet::getName).thenComparing(SaveDet::getId)).toList();
	sds.forEach(str ->System.out.println(str.getId() +" , "+ str.getName()));
	System.out.println("===============================================================================");
		
	sve.stream().filter(as -> as.getId() > 20).sorted(Comparator.comparing(SaveDet::getCompany))
	.forEach(str -> System.out.println(str.getId() + " - " + str.getName() + " - " + str.getCompany()));
	System.out.println("===============================================================================");
		
	
	// find maximum occuring name in a list of object
	SaveDet maxrepeatingName =  sve.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
	.stream().max(Map.Entry.comparingByValue()).get().getKey();
	System.out.println(maxrepeatingName.getId() + " === " + maxrepeatingName.getName() + " == " + maxrepeatingName.getCompany());
	
	System.out.println("===============================================================================");
	
	String ap = "appleal";
	
	
	
	Character firstNonRepChar = ap.chars()
			.mapToObj(mapObject -> Character.valueOf((char)mapObject))
					.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
					.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey()
			;
	System.out.println(firstNonRepChar);
	
	
	List<String> concat = Arrays.asList("test","me","for","concat");
	
	String concated = concat.stream().collect(Collectors.joining("|"));
	System.out.println(concated);
	
	// find nth id from list of objects
	List<SaveDet> sv = new LinkedList();
	SaveDet s112 = new SaveDet(1L,"Muruga","male");
	SaveDet s212 = new SaveDet(4L,"As a Raghu","male");
	SaveDet s412 = new SaveDet(3L,"As a Raghu","male");
	SaveDet s312 = new SaveDet(20L,"Navi","female");
	sv.add(s112);sv.add(s212);sv.add(s312);sv.add(s412);
	
	SaveDet dvNth = sv.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap<SaveDet,Long>::new,Collectors.counting()))
			.entrySet().stream().sorted(Map.Entry.<SaveDet,Long>comparingByKey(Comparator.comparing(SaveDet::getId)))
			.collect(Collectors.toList()).get(3).getKey();
	System.out.println(dvNth.getName() + "-" +dvNth.getId() + "\n===============================================");
	
	// find the pair of number from 2 list that gets the sum of given number
	List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    int targetSum = 7;
    
   list1.stream().
    							flatMap(li1 -> list2.stream().filter(value -> (value + li1) == targetSum)
    									.map(map -> new int[] {li1,map}))
    							.forEach(action -> System.out.println(action[0]+"=="+action[1]));
   System.out.println("========================================================");

//
   
   
   List<SaveDet> grop = new LinkedList();
	SaveDet grop1 = new SaveDet(56L,"Muruga","male");
	SaveDet grop2 = new SaveDet(12L,"As a Raghu","male");
	SaveDet grop3 = new SaveDet(23L,"BS a Navi","female");
	grop.add(grop1);grop.add(s22);grop.add(grop3);
	
	Map<String,Double> svgSalary = grop.stream().collect(Collectors.groupingBy(SaveDet::getCompany, Collectors.averagingDouble(SaveDet::getId) ));
	System.out.println(svgSalary);
	
	
	List<Integer> rdHighest = Arrays.asList(1,2,3,4,5,6);
	System.out.println(rdHighest.stream().sorted(Comparator.reverseOrder()).skip(2).limit(1).findFirst());
	Double dd = rdHighest.stream().collect(Collectors.averagingDouble(Integer::intValue));
	System.out.println(dd);
	
	int target = 4;
	List<int[]> list = rdHighest.stream().filter(sort -> {
		if( rdHighest.contains(target - sort)) {
			return true;
		}else {
			return false;
		}
		}).map(mapper -> new int[] {mapper,target-mapper}).toList();
	list.forEach(ss -> System.out.println(ss[0] + " = "+ ss[1]));
	
	
	
	
	
   
	}
	
	
	
	
	
}
