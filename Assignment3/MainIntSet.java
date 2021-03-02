package Assignment3;

import java.util.Scanner;;

public class MainIntSet {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int noOfElement , item;
	
		
		System.out.println("Enter No Of Elements In The Set");
		noOfElement = scan.nextInt(); 
		Integer[] array = new Integer[noOfElement];
		
		System.out.println("Enter Set Elements");
		for (int i = 0 ; i < noOfElement ; i++ ){
			array[i] = scan.nextInt();
		}
		
		IntSet set1 = new IntSet(array);
		
		System.out.println("Set's Elements are");
		set1.PrintIntSet();
		
		System.out.println("size of the set is" + set1.size());	
		
		System.out.println("Enter an Element to check whether it is a member of set or not");
		item = scan.nextInt();
		
		if(set1.isMember(item)){
			System.out.println("Yes It is");
		}
		else{
			System.out.println("No it isn't");
		}
		
		System.out.println("Complement Set's Elements are");
		set1.getCompliment().PrintIntSet();
		
		System.out.println("Enter no of Element in subset  ");
		noOfElement = scan.nextInt();
		
		Integer []subsetArray = new Integer[noOfElement];
		
		
		System.out.println("Enter Elements for the subset");
		for (int i = 0 ; i < noOfElement ; i++ ){
			subsetArray[i] = scan.nextInt();
		}
		
		IntSet subset = new IntSet(subsetArray);
		
		if (set1.isSubset(subset)){
			System.out.println("Yes it is");
		}
		else{
			System.out.println("No it isn't");
		}
		
		System.out.println("Enter no of Element in the set for union ");
		noOfElement = scan.nextInt();
		
		Integer []unionArray = new Integer[noOfElement];
		
		
		System.out.println("Enter Elements for the subset");
		for (int i = 0 ; i < noOfElement ; i++ ){
			unionArray[i] = scan.nextInt();
		}
		
		IntSet unionSet = new IntSet(unionArray);
		set1.union(unionSet).PrintIntSet();
	}
}
