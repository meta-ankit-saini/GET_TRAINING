package Asssignment4_DSA;

import java.util.HashMap;
import java.util.LinkedHashMap;
/**
 * class to keep track of unique character
 * @author ankit.saini_metacube
 *
 */
public class StringUniqueCharacters {
	HashMap<Character,Integer> characterMap = new HashMap<Character, Integer>();
	
	/**
	 * method to keep track of unique character 
	 * @param input
	 */
	public void updateUniqueCharacters(String input){
		if (input == null){
			System.out.print("empty string");
			return;
		}
		char[] charrArray = input.toCharArray();
		for (char character : charrArray){
			if (Character.isLetter(character)){
				if (characterMap.containsKey(character))
					characterMap.put(character, characterMap.get(character) + 1);
				else
					characterMap.put(character, 1);
			}
		}
	}
	
	/**
	 * method to print unique character
	 */
	public void printUniqueCharecterWithOccurance(){
		if(characterMap.size() == 0){
			System.out.print("empty map");
			return;
		}
		for(char character : characterMap.keySet()){
			System.out.println(character + "  :   " + characterMap.get(character));
		}
	}
	
	public static void main(String[] args){
		StringUniqueCharacters stringMap = new StringUniqueCharacters();
		stringMap.updateUniqueCharacters("Write a method that takes a string and returns the number of unique.");
		stringMap.printUniqueCharecterWithOccurance();
		System.out.println();
		stringMap.updateUniqueCharacters("It is expected that a string with the same character sequence may be ");
		stringMap.printUniqueCharecterWithOccurance();
	}
}
