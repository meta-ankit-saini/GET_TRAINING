package Assignment2_DSA;

import java.util.ArrayList;

/**
 * 
 * Class for Student Structure
 * @author ankit.saini_metacube
 *
 */
public class Student {
	private String name;
	private ArrayList<String> programList;
	
	public Student(String name , ArrayList<String> programList){
		this.programList = programList;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return -> ArrayList of students 
	 */
	public ArrayList<String> getList(){
		ArrayList<String> temp = new ArrayList<String> (programList);
		return temp;
	}
}
