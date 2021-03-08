package Assignment1_DSA;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Polynomial1 {
	
	public static int degree(int[][] polyArray ){
		int noOfRow = polyArray.length , noOfCol = polyArray[0].length , degree = 0 , tempDegree;
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
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("enter polynomial : ");
		String poly = scan.nextLine();
		poly = poly.replaceAll("\\s", ""); 
		if (poly.length() == 0) {
			System.out.print("no polynomial entered");
		}
		int noOfVariable = 0 , noOfTerms = 1;
		Map<Character ,Integer> varToInd = new LinkedHashMap<>();
		Map<Integer , Character> indToVar = new LinkedHashMap<>();
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
		System.out.println(noOfVariable);
		System.out.println(noOfTerms);
		System.out.println(varToInd);
		System.out.println(indToVar);
		System.out.println(poly);
		
		
		int[][] polyArray = new int[noOfTerms][noOfVariable + 1];
		int indexOfString = 0 , currWord = 0 , sign = 1 , currIndex = 0;
		String number = "";
		
		
		while (indexOfString < poly.length()) {
			if (poly.charAt(indexOfString) >= '1' && poly.charAt(indexOfString) <= '9'){
				while( (indexOfString < poly.length()) && (poly.charAt(indexOfString ) >= '0' && poly.charAt(indexOfString) <= '9')){
					number += poly.charAt(indexOfString);
					indexOfString += 1;
				}
				indexOfString -= 1;
//				System.out.print(indexOfString);
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
		
		for(int i = 0 ; i < noOfTerms ; i++){
			for (int j =0 ; j < noOfVariable + 1 ; j++){
				System.out.printf("%d\t",polyArray[i][j]);
			}
			System.out.println();
		}	
		
		System.out.println("degree of polynomial is  " + degree(polyArray));
	}
}
