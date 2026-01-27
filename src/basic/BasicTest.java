package basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class BasicTest {
	
	public static <T> void test(T... a) {
	       
    }

	public static void main(String[] args) {
		
		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		set.add("22");
//		set.add("333");
//		
//		Set<String> set2 = new HashSet<String>();
//		set2.add("11");
//		set2.add("22");
//		
//		System.out.println(set.equals(set2));
		
		List<Integer> numList = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			numList.add(i);
		}
		
		Iterator<Integer> it = numList.iterator();
		System.out.println(it.next());//0
		it.remove();
		System.out.println("size:" + numList.size()); // 9
		while(it.hasNext()) {
			System.out.println("---" + it.next());
		}
		
		System.out.println("first" + numList.get(0));
		
//		
//		
//		numList.add(100);
//		numList.add(200);
//		
//		numList.remove(0);
//		numList.remove(0);
//		
//		System.out.println(numList);
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		

	}
	
	
	

}
