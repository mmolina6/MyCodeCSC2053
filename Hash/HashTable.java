import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTable {
	public static void main(String[] args) { 
		int size = 500; 
		String[] favFoods = new String[size]; 
		//key is the persons name and value is the favorite food 
		
		int maria = "maria".hashCode(); 
		//System.out.println(maria);
		
		maria = maria % size;
		System.out.println(" ");
		System.out.println(maria);
		
		favFoods[maria] = "coffee"; 
		
		int steve = Math.abs("steve".hashCode()); 
		steve = steve % size; 
		System.out.println(steve);
		favFoods[steve] = "ribs"; 
		
		int john = Math.abs("john".hashCode()); 
		john = john % size; 
		System.out.println(john);
		favFoods[john] = "hamburger"; 
		
		HashMap<String, String> map = new HashMap<>(); 
		map.put("NY", "Albany"); 
		map.put("NJ", "Trenton"); 
		map.put("CA", "Sacramento"); 
		
		Set<String> keys = map.keySet(); 
		for (String key: keys) { 
			System.out.println("Key is: " + key + " and value is: " + map.get(key));
		}
		
		for (Map.Entry<String, String> entry: map.entrySet()) { 
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}
