package Assignment3;

import java.util.LinkedHashMap;
import java.util.Map;


public class Poly {
	private final int[][] poly;
	private final int indexOfDegree = 0;
	private final int indexOfCoeff = 1;
	
	/**
	 * constructor to initialize polynomial
	 * @param poly
	 */
	public Poly( int[][] poly ){
		sortPolyByDegree(poly,poly.length);
		this.poly = (int[][]) poly.clone();
	}
	
	/**
	 * method to print polynomial
	 */
	public void printPoly(){
		for(int noOfTerm = 0 ; noOfTerm < poly.length -1 ; noOfTerm++ ){
			System.out.print(poly[noOfTerm][indexOfCoeff] + "x^" + this.poly[noOfTerm][indexOfDegree] + " + " );
		}
		System.out.print(poly[poly.length-1][indexOfCoeff] + "x^" + this.poly[this.poly.length-1][indexOfDegree]) ;
		System.out.println();
	}
	
	/**
	 * method to evaluate function on given value
	 * @param number
	 * @return Double representing value at given number
	 */
	public Double evaluate( Double number){
		Double ans = 0.0;
		for (int noOfTerm = 0 ; noOfTerm < poly.length ; noOfTerm++ ){
			ans +=   poly[noOfTerm][indexOfCoeff] * Math.pow(number , poly[noOfTerm][indexOfDegree]);
		}
		return ans;
	}
	
	/**
	 * method to return degree of polynomial
	 * @return integer representing degree of polynomial
	 */
	public int degree(){
		return poly[0][0];
	}
	
	/**
	 * method to get copy of polynomial matrix
	 * @return polynomial matrix
	 */
	public int[][] getPoly(){
		return this.poly.clone(); 
	}
	
	/**
	 * method to perform polynomial addition
	 * @param p
	 * @return result of polynomial addition 
	 */
	public Poly addPoly(Poly p){
		Map<Integer , Integer> tempResult = new LinkedHashMap<>();
		for (int[] term : this.poly ){
			tempResult.put(term[0], term[1]);
		}
		for (int[] term : p.getPoly()){
			if (tempResult.containsKey(term[0])){
				tempResult.put(term[0],tempResult.get(term[0]) + term[1] );
			}
			else {
				tempResult.put(term[0], term[1]);
			}
		}	
		int len = tempResult.size() , noOfTerm = 0;
		int[][] finalResult = new int[len][2];
		for (int key : tempResult.keySet()){
			finalResult[noOfTerm][indexOfDegree] = key;
			finalResult[noOfTerm][indexOfCoeff] = tempResult.get(key);
			noOfTerm += 1;
		}
		sortPolyByDegree(finalResult,finalResult.length);
		return new Poly(finalResult);
	}
	
	/**
	 * method to perform polynomial multiplication
	 * @param p
	 * @return result of polynomial multiplication 
	 */
	public Poly multiplyPoly(Poly p){
		Map<Integer , Integer> tempResult = new LinkedHashMap<>();
		for (int[] termOfPoly1 : this.poly ){
			for (int[] termOfPoly2 : p.getPoly()) {
				int coefficientResult = termOfPoly1[indexOfCoeff] * termOfPoly2[indexOfCoeff];
				int degreeResult = termOfPoly1[indexOfDegree] + termOfPoly2[indexOfDegree]; 
				if (tempResult.containsKey(degreeResult)){
					tempResult.put(degreeResult, tempResult.get(degreeResult) + coefficientResult);
				}
				else {
					tempResult.put(degreeResult, coefficientResult);
				}
			}
		}
		int len = tempResult.size() , noOfTerm = 0;
		int[][] finalResult = new int[len][2];
		for (int key : tempResult.keySet()){
			finalResult[noOfTerm][indexOfDegree] = (int)key;
			finalResult[noOfTerm][indexOfCoeff] = (int)tempResult.get(key);
			noOfTerm += 1;
		}
		sortPolyByDegree(finalResult,finalResult.length);
		return new Poly(finalResult);
	}
	
	/**
	 * method for sorting the polynomial matrix
	 * @param poly
	 * @param noOfTerms
	 */
	public void sortPolyByDegree(int[][] poly, int noOfTerms){
		int tempForSort;
		for (int i = 0; i < noOfTerms; i++){
			for (int j = 0; j < noOfTerms-(i+1); j++){
				if (poly[j][0] < poly[j+1][0]){
					tempForSort = poly[j][0];
					poly[j][0] = poly[j+1][0];
					poly[j+1][0] = tempForSort;
					tempForSort = poly[j][1];
					poly[j][1] = poly[j+1][1];
					poly[j+1][1] = tempForSort;
				 }
		    }    
		}
	}
}
