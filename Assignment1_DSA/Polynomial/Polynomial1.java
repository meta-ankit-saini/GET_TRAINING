package Assignment1_DSA;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Polynomial1 {
	public static Map<Character ,Integer> varToInd = new LinkedHashMap<>();
	public static Map<Integer , Character> indToVar = new LinkedHashMap<>();
	public static int noOfVariable = 0 , noOfTerms = 1;

	
	/**
	 * method to compute degree of polynomial
	 * @param polyArray -> array representation of polynomial
	 * @return -> integer , degree of polynomial
	 */
	public static int degree(int[][] polyArray ){
		int noOfRow = noOfTerms , noOfCol = noOfVariable , degree = 0 , tempDegree;
		for (int currRow = 0 ; currRow < noOfRow ; currRow ++){
			tempDegree = 0;
			for ( int currCol = 1 ; currCol < noOfCol  ; currCol++){
				tempDegree += polyArray[currRow][currCol];
			}
			if (tempDegree > degree){
				degree = tempDegree;
			}
		}
		return degree;
	}
	
	/**
	 * method to create string polynomial to array representation
	 * @return matrix form of polynomial
	 */
	public static int[][] createPoly1(){
		Scanner scan = new Scanner(System.in);
		System.out.print("enter polynomial : ");
		String poly = scan.nextLine();
		poly = poly.replaceAll("\\s", ""); 
		if (poly.length() == 0) {
			System.out.print("no polynomial entered");
		}
		
		for (int indexOfString = 0 ; indexOfString < poly.length() ; indexOfString++){
			if ( (poly.charAt(indexOfString) >= 'a' && poly.charAt(indexOfString) <= 'z' ) || (poly.charAt(indexOfString) >= 'A' && poly.charAt(indexOfString) <= 'Z' )){
				if(!varToInd.containsKey(poly.charAt(indexOfString))){
					noOfVariable += 1;
					varToInd.put(poly.charAt(indexOfString), noOfVariable);
					indToVar.put(noOfVariable, poly.charAt(indexOfString));
				}
			}
			if ( poly.charAt(indexOfString) == '+' || poly.charAt(indexOfString) == '-' ) {
				noOfTerms += 1;
			}
		}
		
		int[][] polyArray = new int[noOfTerms][noOfVariable + 1];
		int indexOfString = 0 , currWord = 0 , sign = 1 , currIndex = 0;
		String number = "";
		
		for(int indexOfTerm = 0 ; indexOfTerm < noOfTerms ; indexOfTerm ++){
			polyArray[indexOfTerm][0] = 1;
		}
		
		while (indexOfString < poly.length()) {
			if (poly.charAt(indexOfString) >= '1' && poly.charAt(indexOfString) <= '9'){
				while( (indexOfString < poly.length()) && (poly.charAt(indexOfString ) >= '0' && poly.charAt(indexOfString) <= '9')){
					number += poly.charAt(indexOfString);
					indexOfString += 1;
				}
				indexOfString -= 1;
				polyArray[currWord][0] =  Integer.parseInt(number) * sign;
				number = "";
			}
			else if( (poly.charAt(indexOfString) >= 'a' && poly.charAt(indexOfString) <= 'z' ) ||  (poly.charAt(indexOfString) >= 'A' && poly.charAt(indexOfString) <= 'Z' )){
				currIndex = varToInd.get(poly.charAt(indexOfString));
				if( ((indexOfString + 1) < poly.length()) && poly.charAt(indexOfString + 1) == '^'){
					indexOfString += 2;
					while( (indexOfString < poly.length()) && ( poly.charAt(indexOfString ) >= '0' && poly.charAt(indexOfString) <= '9') ){
						number += poly.charAt(indexOfString);
						indexOfString += 1;
					}
					indexOfString -= 1;
					polyArray[currWord][currIndex] = Integer.parseInt(number); 
					number ="";
				}
				else {
					polyArray[currWord][currIndex] = 1;
				}
				
			}
			else if(poly.charAt(indexOfString) == '+'){
				currWord += 1;
				sign = 1;
			}
			
			else if(poly.charAt(indexOfString) == '-'){
				currWord += 1;
				sign = -1;
			}
			else {
				continue;
			}
			indexOfString += 1;
		}
		return polyArray;
	}
	
	/**
	 * method to print matrix of polynomial
	 * @param polyArray -> matrix representation of polynomial
	 */
	public static void printPolyArray(int[][] polyArray){
		for(int i = 0 ; i < noOfTerms ; i++){
			for (int j =0 ; j < noOfVariable + 1 ; j++){
				System.out.printf("%d\t",polyArray[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * method to print polynomial from array form
	 * @param polyArray -> matrix representation of polynomial
	 */
	public static void printPolyFromPolyArray(int[][] polyArray){
		for(int i = 0 ; i < noOfTerms ; i++){
			for (int j =0 ; j < noOfVariable + 1 ; j++){
				if (j == 0){
					System.out.printf("%d",polyArray[i][j]);
				}
				else if (polyArray[i][j] != 0){
					System.out.printf("%c^%d",indToVar.get(j) ,polyArray[i][j]);
				}
				else{
					continue;
				}
			}
		if (i != noOfTerms - 1 ){
			System.out.print(" + ");
		}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[][] polyArray = createPoly1();
		System.out.println("Poly Array : ");
		printPolyArray(polyArray);
		System.out.println("Poly Array : ");
		printPolyFromPolyArray(polyArray);
		System.out.println("degree of polynomial is  " + degree(polyArray));
	}
}
