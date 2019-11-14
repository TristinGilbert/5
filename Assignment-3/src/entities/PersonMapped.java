/*
 * This code is created to hold the hashmaps to return person information
 * 
 * Authors: Max Van Arsdall and Tristin Gilbert
 * 
 * 
 */
package entities;

import java.util.HashMap;

public class PersonMapped {
	
	//hashmap to return a person
	private static HashMap<String, String> personMapped = new HashMap<String, String>();
	
	public static void setPersonMapped(HashMap<String, String> map) {
		personMapped = map;
	}
	
	public static String findPersonName(String personCode) {
		
		String name = personMapped.get(personCode);
		return name;
	}
	
	
}
