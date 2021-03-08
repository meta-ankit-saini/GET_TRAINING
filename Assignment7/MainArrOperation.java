package Assignment7;

import java.util.Scanner;

/**
 * Main Class for ArrOperation
 * @author ankit.saini_metacube
 *
 */
public class MainArrOperation {

	/**
	 * method for taking array input
	 * @return -> array
	 */
	public static int[] inputArray(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no Of elements in array");
		int noOfElement = scan.nextInt();
		int[] arr = new int[noOfElement];
		
		for(int indexOfElement = 0 ;indexOfElement < noOfElement ; indexOfElement++){
			arr[indexOfElement] = scan.nextInt();
		}
		return arr;
	}
	
	public static void main(String []args){
		Scanner scan = new Scanner(System.in);
		ArrOperation arrOperation = new ArrOperation();
		
		System.out.println("MaxMirror :" );
		int[] arr1 = inputArray(); 
		System.out.println("length of Max mirror"+arrOperation.maxMirror(arr1));
		
		System.out.println("Count Clumps :" );
		int[] arr2 = inputArray();
		System.out.println("Clumps "+arrOperation.countClumps(arr2));
		
		System.out.println("fixXY :" );
		int[] arr3 = inputArray();
		System.out.println("enter X : ");
		int X = scan.nextInt();
		System.out.println("enter Y : ");
		int Y = scan.nextInt();
		System.out.println("fixXY : "+arrOperation.fixXY(arr3, X, Y));
		
		System.out.println("Split Array :" );
		int[] arr4 = inputArray();
		System.out.println("index : " + arrOperation.splitArray(arr4));
	}
}
