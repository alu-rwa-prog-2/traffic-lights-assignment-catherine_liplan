// Author: Catherine Muthoni

import java.util.HashMap;

public class CopyMap {

	public static void main(String[] args) {
		// HashMap1
		HashMap<String, Integer> weights = new HashMap <String,Integer>();
		
		weights.put("Cate", 59);
		weights.put("Cherry", 62);
		weights.put("Liplan", 70);
		weights.put("John", 50);
		
		System.out.println("HashMap 1");
		System.out.println(weights);
		
		// Copy of HashMap1
		HashMap<String, Integer> weights2 = new HashMap<String, Integer>();
		
		weights2.putAll(weights);
		System.out.println(" Copy of HashMap 1");
		System.out.println(weights2);
		
		// HashMap2
		HashMap<String, Integer> heights = new HashMap <String,Integer>();
				
		heights.put("Cate", 165);
		heights.put("Cherry", 142);
		heights.put("Liplan", 178);
		heights.put("John", 150);
		
		System.out.println("HashMap 2");
		System.out.println(heights);
		
		// Copy of HashMap2
		HashMap<String, Integer> heights2 = new HashMap<String, Integer>();
				
		heights2.putAll(heights);
		System.out.println("Copy of HashMap 2");
		System.out.println(heights2);
		
		// HashMap3		
		HashMap<String, Integer> ages = new HashMap <String,Integer>();
				
		ages.put("Cate", 29);
		ages.put("Cherry", 26);
		ages.put("Liplan", 25);
		ages.put("John", 32);
		
		System.out.println("HashMap 3");
		System.out.println(ages);
		
		// Copy of HashMap3
		HashMap<String, Integer> ages2 = new HashMap<String, Integer>();
		
		System.out.println("Copy of HashMap 3");
		ages2.putAll(ages);
		System.out.println(ages2);
				


	}

	
}
