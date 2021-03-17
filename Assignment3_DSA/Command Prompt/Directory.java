package Asssignment3_DSA;

import java.util.ArrayList;

public class Directory {
	private final Directory parentDirectory;
	private String path;
	private String name;
	private ArrayList<Directory> subDirectories;
	
	public Directory(String name, Directory parentDirectory) {
		this.name = name;
		this.parentDirectory = parentDirectory;
		this.path = setPath();
		this.subDirectories =  new ArrayList<Directory>();
	}
		
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
	
	public String getPath(){
		return path;
	}
	
	public String getName(){
		return name;
	}
	
	public void changeName(String name){
		this.path = name;
	}
	
	public Directory getParentDirectory(){
		return parentDirectory;
	}
	
	public void addSubDirectory(Directory directory){
		subDirectories.add(directory);
	}
	
	public ArrayList<Directory> getSubDirectories(){
		return new ArrayList<Directory>(subDirectories);
	}
	
	public void deleteDirectory(Directory directory){
		if(!subDirectories.contains(directory)){
			throw new AssertionError("Directory not Available");
		}
		subDirectories.remove(directory);
	}
	
	public Directory findDirectory(String name){
		for (Directory direcory : subDirectories){
			if(name.equals(direcory.name))
				return direcory;
		}
		return null;
	}
	
	public boolean checkAvailabality(String name){
		for (Directory direcory : subDirectories){
			if(path.equals(direcory.name))
				return false;
		}
		return true;
	}
	
	public void printCurrentDirectory(){
		for (Directory directory : subDirectories){
			System.out.print(directory.getPath() + "     ");
		}
	}
}
