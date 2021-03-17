package Asssignment3_DSA;

import java.util.ArrayList;

public class DirectoryManager {
	private final Directory root; 
	private Directory currentDirectory; 
	
	public DirectoryManager(){
		root = new Directory("root" , null);
		currentDirectory = root;
	}
	
	public void changeDirectory(String path) throws AssertionError{
		if(path == null){
			throw new AssertionError("path can't be Null");
		}
		Directory directory = currentDirectory.findDirectory(path);
		if (directory != null){
			currentDirectory = directory;
			return;
		}
		throw new AssertionError("Directory Not Found");
	}
	
	public void createDirectory(String path) throws AssertionError {
		if(path == null){
			throw new AssertionError("Name can't be Null");
		}
		if (currentDirectory.checkAvailabality(path)){
			Directory directory = new Directory(path,currentDirectory);
			currentDirectory.addSubDirectory(directory);
			return;
		}
		throw new AssertionError("this name already exists");
	}
	
	public void changeCurrentDirectoryToParentDirectory()  {
		Directory directory = currentDirectory.getParentDirectory();
		if(directory != null){
			currentDirectory = directory;
			return;
		}
		throw new AssertionError("No Parent Directory");
	}
	
	private Directory findRecursiveInDirectory(String name, Directory directory ,Directory resultDirectory){
        if (currentDirectory.getSubDirectories().size() <= 0){
        	return null;
        }
        if(directory.getName().equals(name))
        	return directory;
        for(Directory subDirectory : directory.getSubDirectories())
        	resultDirectory = findRecursiveInDirectory(name, subDirectory ,resultDirectory );
		return resultDirectory;
	}
	
	public Directory find(String name){
		if(name == null){
			throw new AssertionError("Name cannot be null");
		}
		Directory resultDirectory = null;
		return findRecursiveInDirectory(name, currentDirectory, resultDirectory);
	}
	
	public ArrayList<Directory> arrayListOfDirectories(){
		return currentDirectory.getSubDirectories();
	}
	
	public Directory getRoot(){
		return this.root;
	}
	
	public void printCurrentDirectory(){
		for (Directory directory : currentDirectory.getSubDirectories()){
			System.out.print(directory.getName() + "     ");
		}
		System.out.println();
	}
}
