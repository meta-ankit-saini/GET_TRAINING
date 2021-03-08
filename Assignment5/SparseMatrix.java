package Assignment5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.lang.model.type.NoType;
import javax.swing.text.StyleContext.SmallAttributeSet;

/**
 * class for Sparse Matrix methods
 * @author ankit.saini_metacube
 *
 */
public class SparseMatrix {
    private final Map<Key , Integer> sparseMatrix;
	
	private final  int rowIndex = 0 ;  
	private final int colIndex = 1 ;    
	private final int elementIndex = 2; 
	
	private final int noOfRows ;
	private final int noOfColumns ;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colIndex;
		result = prime * result + elementIndex;
		result = prime * result + noOfColumns;
		result = prime * result + noOfRows;
		result = prime * result + rowIndex;
		result = prime * result
				+ ((sparseMatrix == null) ? 0 : sparseMatrix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SparseMatrix other = (SparseMatrix) obj;
		if (colIndex != other.colIndex)
			return false;
		if (elementIndex != other.elementIndex)
			return false;
		if (noOfColumns != other.noOfColumns)
			return false;
		if (noOfRows != other.noOfRows)
			return false;
		if (rowIndex != other.rowIndex)
			return false;
		if (sparseMatrix == null) {
			if (other.sparseMatrix != null)
				return false;
		} else if (!sparseMatrix.equals(other.sparseMatrix))
			return false;
		return true;
	}
	
	/**
	 * constructor for storing data of sparse matrix
	 * @param noOfRowS -> no of rows in Matrix 
	 * @param noOfColumns -> no of columns in Matrix 
	 * @param sparseMatrix -> sparse matrix created from createSparseMatrix method of MainSparseMatrix class of type Map<Key,Integer>
	 */
	public SparseMatrix( int noOfRows , int noOfColumns , Map<Key , Integer> sparseMatrix ){
		this.sparseMatrix  = new LinkedHashMap<>(sparseMatrix);
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
	}
	
	/**
	 * 
	 * @return -> Sparse Matrix of type Map<Key,Integer>
	 */
	public LinkedHashMap<Key , Integer> getSparseMatrix(){
		return new LinkedHashMap<Key , Integer>(sparseMatrix);
	}
	
	/**
	 * method for getting element at key location
	 * @param key of Key type
	 * @return -> element of Integer type at key location 
	 */
	public int get(Key key){
		if (sparseMatrix.containsKey(key)){
			return sparseMatrix.get(key);
		}
		return 0;
	}
	
	/**
	 * method for printing Matrix
	 */
	public void printSparseMatrix(){ 
		Key key = new Key();
		for(Integer indexOfX = 0 ; indexOfX < noOfRows ; indexOfX ++){
			key.row = indexOfX;
			for (Integer indexOfY = 0 ; indexOfY< noOfColumns ; indexOfY++){
				key.col = indexOfY;
				if (sparseMatrix.containsKey(key)){
					System.out.print(sparseMatrix.get(key)+"    ");
				}
				else {
					System.out.print(0+"    ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * method for computing transpose of sparse matrix
	 * @return -> transposed Sparse matrix 
	 */
	public SparseMatrix getTransposeSparseMatrix(){
		Map<Key , Integer> transposeSparseMatrix = new LinkedHashMap<Key , Integer>();
		for (Key key : sparseMatrix.keySet()){
			Key tempKey = new Key();
			tempKey.row = key.col;
			tempKey.col = key.row;
			transposeSparseMatrix.put( tempKey, sparseMatrix.get(key));
		}
		return new SparseMatrix(noOfRows, noOfColumns, transposeSparseMatrix);
	}
	
	/**
	 * Method to find if Matrix is Symmetric.
	 * @return boolean, true if Matrix is symmetric otherwise false.
	 */
	public boolean isSymmetric(){
		if ( noOfColumns != noOfRows  ){
			return false ;
		}
		Key tempKey = new Key();
		for (Key key: sparseMatrix.keySet()){
			tempKey.row = key.col;
			tempKey.col = key.row;
			if(sparseMatrix.get(key) != sparseMatrix.get(tempKey)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * method for adding two Sparse Matrix
	 * @param sparseMatrix2
	 * @return Sparse matrix containing addition result  
	 */
	public SparseMatrix addSparseMatrix(SparseMatrix sparseMatrix2){
		if(this.noOfRows != sparseMatrix2.noOfRows || this.noOfColumns != sparseMatrix2.noOfColumns){
			throw new AssertionError("Dimension doesn't match ");
		}
		
		Map<Key , Integer> resultantSparseMatrix = new LinkedHashMap<Key , Integer>();
		for (Key key : sparseMatrix.keySet()){
			resultantSparseMatrix.put( key, sparseMatrix.get(key));
		}
		for (Key key : sparseMatrix2.sparseMatrix.keySet()){
			if (resultantSparseMatrix.containsKey(key)){
				resultantSparseMatrix.put(key, resultantSparseMatrix.get(key) + sparseMatrix2.sparseMatrix.get(key));
			}
			else{
				resultantSparseMatrix.put( key, sparseMatrix2.sparseMatrix.get(key));
			}
		}
		return new SparseMatrix(noOfRows, noOfColumns, resultantSparseMatrix);
	}
	
	/**
	 * method for multiplying two Sparse Matrix
	 * @param sparseMatrix2
	 * @return Sparse matrix containing multiplicationtion result
	 */
	public SparseMatrix multiplySparseMatrix(SparseMatrix sparseMatrix2){
		if(this.noOfColumns != sparseMatrix2.noOfRows){
			throw new AssertionError("Invalid Shape");
		}
		Map<Key , Integer> resultantSparseMatrix = new LinkedHashMap<Key , Integer>();
		for( int row1 = 0 ; row1 < this.noOfRows ; row1++ ){
			Key key2 = new Key()  ,key3 = new Key() , key1 = new Key();
			key1.row = row1;
			key2.row = row1;
			for( int col1 = 0 ; col1 < sparseMatrix2.noOfColumns ; col1++ ){
				key3.col = col1;
				key1.col = col1;
				int tempElement = 0;
				for ( int col2 = 0 ; col2 < sparseMatrix2.noOfRows ; col2 ++){
					key2.col = col2;
					key3.row = col2;
					tempElement += this.get(key2) * sparseMatrix2.get(key3);
				}
				if (tempElement != 0) {
					Key k = new Key();
					k.row = key1.row;
					k.col = key1.col;
					resultantSparseMatrix.put(k,tempElement);
				}
			}
		}
		return new SparseMatrix(this.noOfRows, sparseMatrix2.noOfColumns, resultantSparseMatrix);
	}
	
}
