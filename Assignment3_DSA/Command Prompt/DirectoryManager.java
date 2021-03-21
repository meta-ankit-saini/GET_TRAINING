package Asssignment3_DSA;

import java.util.ArrayList;
/**
 * class for managing directories
 * @author ankit.saini_metacube
 *
 */
public class DirectoryManager {
	private final Directory root; 
	private Directory currentDirectory; 
	
	/**
	 * constructor to initialize DirectoryManager
	 */
	public DirectoryManager(){
		root = new Directory("root" , null);
		currentDirectory = root;
	}
	
	/**
	 * method to change current directory
	 * @param path
	 * @throws AssertionError
	 */
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
	
	/**
	 * method to create new directory
	 * @param path
	 * @throws AssertionError
	 */
	public void createDirectory(String name) throws AssertionError {
		if(name == null){
			throw new AssertionError("Name can't be Null");
		}
		if (currentDirectory.checkAvailabality(name)){
			Directory directory = new Directory(name,currentDirectory);
			currentDirectory.addSubDirectory(directory);
			return;
		}
		throw new AssertionError("this name already exists");
	}
	
	/**
	 * method to change current directory to it's parent directory
	 */
	public void changeCurrentDirectoryToParentDirectory()  {
		Directory directory = currentDirectory.getParentDirectory();
		if(directory != null){
			currentDirectory = directory;
			return;
		}
		throw new AssertionError("No Parent Directory");
	}
	
	/**
	 * method to find directory recursively
	 * @param name
	 * @param directory
	 * @param resultDirectory
	 * @return -> directory
	 */
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
	
	/**
	 * method to find directory using name , works as helper method for findRecursiveInDirectory()
	 * @param name
	 * @return -> Directory if find else null
	 */
	public Directory find(String name){
		if(name == null){
			throw new AssertionError("Name cannot be null");
		}
		Directory resultDirectory = null;
		return findRecursiveInDirectory(name, currentDirectory, resultDirectory);
	}
	
	/**
	 * method to get ArrayList Of Sub directories
	 * @return -> ArrayList Of Sub directories
	 */
	public ArrayList<Directory> arrayListOfDirectories(){
		return currentDirectory.getSubDirectories();
	}
	
	/**
	 * method to get root Directory
	 * @return
	 */
	public Directory getRoot(){
		return this.root;
	}
	
	/**
	 * method to print sub directories
	 */
	public void printCurrentDirectory(){
		for (Directory directory : currentDirectory.getSubDirectories()){
			System.out.print(directory.getName() + "     ");
		}
		System.out.println();
	}
}
