package Asssignment3_DSA;

import java.util.Scanner;

public class CommandPrompt {
	
	/**
	 * print tree structure of directories
	 * @param headDirectory
	 * @param level
	 */
	public static void printDirectory(Directory headDirectory,int level){
		if(level!=0){
			System.out.print("|");
		}
		for(int space = 1 ; space <= (level-1)*5 ;space++){
			System.out.print(" ");
		}
		if(level!=0){
			System.out.print("*****");
		}
		System.out.println(headDirectory.getName());
		if(headDirectory.getSubDirectories().size()>0){
			if(level!=0){
				System.out.print("|");
			}
			for(int spaceNo = 1 ; spaceNo <= (level)*5 ;spaceNo++){
				System.out.print(" ");
			}
			System.out.println("|");
			for(Directory subDirectory : headDirectory.getSubDirectories()){
				printDirectory(subDirectory, level+1);
			}
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		DirectoryManager directoryManager = new DirectoryManager();
		System.out.println("Enter 'mkdir dir_name' for creating directory " );
		System.out.println("Enter 'ls' for printing all sub directory of current directory " );
		System.out.println("Enter 'cd dir_name' for changing current directory " );
		System.out.println("Enter 'bk' for changing cureent directory to parent directory " );
		System.out.println("Enter 'find dir_name' for finding directory " );
		System.out.println("Enter 'tree' for printing tree" );
		System.out.println("Enter 'exit' for closing the application" );
		String choice = "abc";
		while (!choice.equals("exit")){
			System.out.println("Enter command :   ");
			String[] command  = scan.nextLine().split(" ");
			choice = command[0];
			if(command.length > 2){
	 			throw new AssertionError("Invalid Command");
			}
			switch (choice) {
				case "mkdir": directoryManager.createDirectory(command[1]);
			              	  break;
				
				case "ls"   : directoryManager.printCurrentDirectory();
							  break;
			              	  
				case "cd"   : directoryManager.changeDirectory(command[1]);
							  break;	 
				
				case "bk"   : directoryManager.changeCurrentDirectoryToParentDirectory();;
		  					  break;
				
				case "find" : Directory resultDirectory = directoryManager.find(command[1]);
			            	  System.out.println(resultDirectory.getPath());
			            	  break;	
				  		
				case "tree" : Directory headDirectory = directoryManager.getRoot();
	 						  printDirectory(headDirectory,0);
	 						  break;
						
				case "exit" : break;
				          

				default		: System.out.println("Command Not Found");
							  break;
			}
		}
	}
}	

