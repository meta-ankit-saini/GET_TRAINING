package Asssignment3_DSA;

import java.util.ArrayList;

public class Directory {
	private final Directory parentDirectory;
	private String path;
	private String name;
	private ArrayList<Directory> subDirectories;
	
	public Directory(String path, Directory parentDirectory) {
		this.name = null;
		this.path = path;
		this.parentDirectory = parentDirectory;
		this.subDirectories =  new ArrayList<Directory>();
	}
		
		
	public String getPath(){
		return path;
	}
	
	public String getName(){
		return path;
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
	
	public Directory findDirectory(String path){
		for (Directory direcory : subDirectories){
			if(path.equals(direcory.path))
				return direcory;
		}
		return null;
	}
	
	public boolean checkAvailabality(String path){
		for (Directory direcory : subDirectories){
			if(path.equals(direcory.path))
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
