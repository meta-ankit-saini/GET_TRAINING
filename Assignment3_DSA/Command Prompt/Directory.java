package Asssignment3_DSA;

import java.util.ArrayList;

/**
 * class implements structure of Directory
 * @author ankit.saini_metacube
 *
 */
public class Directory {
	private final Directory parentDirectory;
	private String path;
	private String name;
	private ArrayList<Directory> subDirectories;
	
	/**
	 * constructor for creating directory 
	 * @param name
	 * @param parentDirectory
	 */
	public Directory(String name, Directory parentDirectory) {
		this.name = name;
		this.parentDirectory = parentDirectory;
		this.path = setPath();
		this.subDirectories =  new ArrayList<Directory>();
	}
		
	/**
	 * method for creating path of current directory
	 * @return -> path
	 */
	public String setPath(){
		String temp = "";
		Directory currDirectory = parentDirectory;
		while(currDirectory != null){
			temp =  currDirectory.getName() + "//" + temp ;
			currDirectory = currDirectory.getParentDirectory();
		}
		temp = "://" + temp + name;
		return temp;
	}
	
	/**
	 * method to get path of directory
	 * @return
	 */
	public String getPath(){
		return path;
	}
	
	/**
	 * method to get name of directory
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * method to get change name of directory
	 */
	public void changeName(String name){
		this.path = name;
	}
	
	/**
	 * method to get parent Directory
	 * @return -> parentDirectory
	 */
	public Directory getParentDirectory(){
		return parentDirectory;
	}
	
	/**
	 * method to add sub Directory
	 * @param directory
	 */
	public void addSubDirectory(Directory directory){
		subDirectories.add(directory);
	}
	
	/**
	 * method to get sub directories
	 * @return -> ArrayList of sub directories
	 */
	public ArrayList<Directory> getSubDirectories(){
		return new ArrayList<Directory>(subDirectories);
	}
	
	/**
	 * method to delete directory
	 * @param directory
	 */
	public void deleteDirectory(Directory directory){
		if(!subDirectories.contains(directory)){
			throw new AssertionError("Directory not Available");
		}
		subDirectories.remove(directory);
	}
	
	/**
	 * method to find Directory in sub directories
	 * @param name
	 * @return -> Directory
	 */
	public Directory findDirectory(String name){
		for (Directory direcory : subDirectories){
			if(name.equals(direcory.name))
				return direcory;
		}
		return null;
	}
	
	/**
	 * method to check availability of name for directory
	 * @param name
	 * @return -> true if name is available else false
	 */
	public boolean checkAvailabality(String name){
		for (Directory direcory : subDirectories){
			if(path.equals(direcory.name))
				return false;
		}
		return true;
	}
	
	/**
	 * method to print sub
	 */
	public void printCurrentDirectory(){
		for (Directory directory : subDirectories){
			System.out.print(directory.getPath() + "     ");
		}
	}
}
