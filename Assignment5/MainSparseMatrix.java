package Assignment5;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class to check functions of Sparse Matrix 
 * @author ankit.saini_metacube
 *
 */
public class MainSparseMatrix {
	private static int rowIndex = 0 ;  
	private static int colIndex = 1 ;    
	private static int elementIndex = 2; 
	 
	/**
	 * method to create Map uses in creation of Sparse Matrix
	 * @param noOfRowS -> no of rows in Matrix 
	 * @param noOfColumns -> no of columns in Matrix 
	 * @param noOfElements -> no of non-zero elements in Matrix 
	 * @return -> Sparse Matrix stored in Map where indexes -> Key and data -> Value
	 */
	public static Map<Key , Integer> createSparseMatrix(int noOfRowS , int noOfColumns ,int noOfElements ){
		Scanner scan = new  Scanner(System.in);
		Integer  element ;
		Map<Key , Integer> sparseMatrix = new LinkedHashMap<>();
		for (int indexOfElement = 0 ; indexOfElement < noOfElements ; indexOfElement++ ){
			Key key = new Key();
			System.out.println("enter row no : ");
			key.row =  scan.nextInt();
			System.out.println("enter col no : ");
			key.col =  scan.nextInt();
			System.out.println("enter data element : ");
			element =  scan.nextInt();
			if ( key.row < noOfRowS  && key.col < noOfColumns  ) {
				sparseMatrix.put(key, element);
			}
			else {
				throw new AssertionError("Invalid row or col") ;	
			}
		}
		return sparseMatrix;
	}
	
	public static void main(String []args){

		Scanner scan = new  Scanner(System.in);
		System.out.println("enter no Of Row : ");
		int noOfRows = scan.nextInt();
		System.out.println("enter no Of Col : ");
		int noOfColumns = scan.nextInt();
		System.out.println("enter no Of element : ");
		int noOfElements = scan.nextInt();
				
		Map<Key , Integer> tempSparseMatrix = createSparseMatrix(noOfRows, noOfColumns, noOfElements);	
		SparseMatrix sparseMatrix = new SparseMatrix(noOfRows, noOfColumns, tempSparseMatrix);
		System.out.println("Sparse Matrix : ");
		sparseMatrix.printSparseMatrix();
		
		System.out.println("Transpose of Sparse Matrix : ");
		SparseMatrix transposeMatrix = sparseMatrix.getTransposeSparseMatrix();
		transposeMatrix.printSparseMatrix();
		
		System.out.println("Is Sparse Matrix Symmetric : " + "" + sparseMatrix.isSymmetric());
		
		System.out.println("enter matrxi for Addition : ");
		System.out.println("enter no Of Row : ");
		int noOfRows2 = scan.nextInt();
		System.out.println("enter no Of Col : ");
		int noOfColumns2 = scan.nextInt();
		System.out.println("enter no Of element : ");
		int noOfElements2 = scan.nextInt();
		
		Map<Key , Integer> tempSparseMatrix2 = createSparseMatrix(noOfRows2, noOfColumns2, noOfElements2);
		SparseMatrix sparseMatrix2 = new SparseMatrix(noOfRows2, noOfColumns2, tempSparseMatrix2);
		
		SparseMatrix addSparseMatrixResult = sparseMatrix.addSparseMatrix(sparseMatrix2);
		System.out.println("Result of Matrix Addition: ");
		addSparseMatrixResult.printSparseMatrix();
		
		System.out.println("enter matrxi for muliplication : ");
		System.out.println("enter no Of Row : ");
		int noOfRows3 = scan.nextInt();
		System.out.println("enter no Of Col : ");
		int noOfColumns3 = scan.nextInt();
		System.out.println("enter no Of element : ");
		int noOfElements3 = scan.nextInt();
		
		Map<Key , Integer> tempSparseMatrix3 = createSparseMatrix(noOfRows3, noOfColumns3, noOfElements3);
		SparseMatrix sparseMatrix3 = new SparseMatrix(noOfRows3, noOfColumns3, tempSparseMatrix3);
		
		System.out.println("Result of Matrix Multi : ");
		SparseMatrix multiplySparseMatrixResult = sparseMatrix.multiplySparseMatrix(sparseMatrix3);
		multiplySparseMatrixResult.printSparseMatrix();
		
	}
}
