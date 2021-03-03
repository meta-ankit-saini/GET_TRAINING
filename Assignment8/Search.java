package Assignment8;

import java.util.Scanner;
import java.util.Arrays;

/**
 * class for search methods
 * @author ankit.saini_metacube
 *
 */
public class Search {
	
	/**
	 * method searching the element in array using Linear Search
	 * @param array -> Array of Integers requires not null or of Zero length
	 * @param lowerBound -> starting index for search
	 * @param uperBound -> index till we want to search
	 * @param key -> Value to Be Search 
	 * @return index at which element is present , if not then -1
	 */
	public static int linearSearch(int[] array , int lowerBound , int uperBound ,int key){
		if( uperBound < lowerBound){
			return -1;
		}
		if (array[lowerBound] == key){
			return lowerBound;
		}
		if (array[uperBound] == key){
			return uperBound;
		}
		return linearSearch(array, lowerBound + 1, uperBound - 1, key);
	}
	
	/**
	 * 
	 * @param array -> Array of Integers requires not null or of Zero length
	 * @param lowerBound -> starting index for search
	 * @param uperBound -> index till we want to search
	 * @param key -> Value to Be Search
	 * @return index at which element is present , if not then -1
	 */
	public static int binarySearch(int[] array , int lowerBound , int uperBound ,int key){
		if ( lowerBound <= uperBound ){
			int mid = lowerBound + (uperBound - lowerBound )/2 ;
			
			if( array[mid] == key ){
				return mid;
			}
			else if (array[mid] > key ){
				return binarySearch(array, lowerBound,mid -1 , key);
			}
			else{
				return binarySearch(array, mid + 1, uperBound, key);
			}
		}
		return -1;
	}
		
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int noOfElements , key;
		System.out.println("Enter no of Elements");
		noOfElements = scan.nextInt();
		
		int[] array = new int[noOfElements];
		System.out.println("Enter no of Elements");
		for (int i = 0; i < noOfElements; i++ ){
			array[i] = scan.nextInt();
		}
		System.out.println("Enter Element to search");
		key = scan.nextInt();
		System.out.println("By linear search : "+linearSearch(array, 0, noOfElements-1, key) );
		System.out.println("Array Sorted for Binary Search");
		Arrays.sort(array);
		System.out.println("By binary search : "+binarySearch(array, 0, noOfElements-1, key));
		
	}
}
