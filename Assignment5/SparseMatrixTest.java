package Assignment5;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * test class of Sparse Matrix
 * @author ankit.saini_metacube
 *
 */
public class SparseMatrixTest {

	/**
	 * Method For testing Sparse Matrix Methods Result
	 */
	@Test
	public void Test() {
		
		Map<Key , Integer> matrix1 = new LinkedHashMap<>();
		matrix1.put(new Key(0,0), 2);
		matrix1.put(new Key(0,2), 3);
		matrix1.put(new Key(2,0), 1);
		matrix1.put(new Key(2,2), 2);
		matrix1.put(new Key(2,3), 89);
		matrix1.put(new Key(3,1), 3);
		matrix1.put(new Key(3,3), 5);
		
		Map<Key , Integer> matrix2 = new LinkedHashMap<>();
		matrix2.put(new Key(0,0), 2);
		matrix2.put(new Key(0,2), 3);
		matrix2.put(new Key(2,0), 3);
		matrix2.put(new Key(2,2), 2);
		matrix2.put(new Key(2,3), 89);
		matrix2.put(new Key(3,2), 89);
		matrix2.put(new Key(3,3), 5);
	
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix2 = new SparseMatrix(4,4,matrix2);
		SparseMatrix sparseMatrix3 = new SparseMatrix(4,5,matrix2);
		
		//Test For isSymmetric
		assertEquals(false,sparseMatrix1.isSymmetric());
		assertEquals(true,sparseMatrix2.isSymmetric());
		assertEquals(false,sparseMatrix3.isSymmetric());
		
		//Test For Transpose
		Map<Key , Integer> result1 = new LinkedHashMap<>();
		result1.put(new Key(0,0), 2);
		result1.put(new Key(0,2), 1);
		result1.put(new Key(2,0), 3);
		result1.put(new Key(2,2), 2);
		result1.put(new Key(3,2), 89);
		result1.put(new Key(1,3), 3);
		result1.put(new Key(3,3), 5);
		
		Map<Key , Integer> result2 = new LinkedHashMap<>();
		result2.put(new Key(0,0), 2);
		result2.put(new Key(0,2), 3);
		result2.put(new Key(2,0), 3);
		result2.put(new Key(2,2), 2);
		result2.put(new Key(2,3), 89);
		result2.put(new Key(3,2), 89);
		result2.put(new Key(3,3), 5);
		
		
		SparseMatrix resultsparseMatrix1 = new SparseMatrix(4,4,result1);
		SparseMatrix resultsparseMatrix2 = new SparseMatrix(4,4,result2);
		SparseMatrix resultsparseMatrix3 = new SparseMatrix(4,5,result2);

		assertEquals(resultsparseMatrix1, sparseMatrix1.getTransposeSparseMatrix());
		assertEquals(resultsparseMatrix2, sparseMatrix2.getTransposeSparseMatrix());
		assertEquals(resultsparseMatrix3, sparseMatrix3.getTransposeSparseMatrix());
		
		
		//Test For Addition
		
		Map<Key , Integer> result3 = new LinkedHashMap<>();
		result3.put(new Key(0,0), 4);
		result3.put(new Key(0,2), 6);
		result3.put(new Key(2,0), 4);
		result3.put(new Key(2,2), 4);
		result3.put(new Key(2,3), 178);
		result3.put(new Key(3,1), 3);
		result3.put(new Key(3,2), 89);
		result3.put(new Key(3,3), 10);
		SparseMatrix resultsparseMatrix4 = new SparseMatrix(4,4,result3);
		assertEquals(resultsparseMatrix4, sparseMatrix1.addSparseMatrix(sparseMatrix2));
		
		//Test For Multiplication
		Map<Key , Integer> result4 = new LinkedHashMap<>();
		result4.put(new Key(0,0), 13);
		result4.put(new Key(0,2), 12);
		result4.put(new Key(0,3), 267);
		result4.put(new Key(2,0), 8);
		result4.put(new Key(2,2), 7928);
		result4.put(new Key(2,3), 623);
		result4.put(new Key(3,2), 445);
		result4.put(new Key(3,3), 25);
		SparseMatrix resultsparseMatrix5 = new SparseMatrix(4,4,result4);
		resultsparseMatrix5.printSparseMatrix();
		sparseMatrix1.multiplySparseMatrix(sparseMatrix2).printSparseMatrix();
        assertEquals(resultsparseMatrix5, sparseMatrix1.multiplySparseMatrix(sparseMatrix2));
	}
	
	/**
	 * Test Case for Sparse MAtrix Addition Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestForAddition(){
		Map<Key , Integer> matrix1 = new LinkedHashMap<>();
		matrix1.put(new Key(0,0), 2);
		matrix1.put(new Key(0,2), 3);
		matrix1.put(new Key(2,0), 1);
		matrix1.put(new Key(2,2), 2);
		matrix1.put(new Key(2,3), 89);
		matrix1.put(new Key(3,1), 3);
		matrix1.put(new Key(3,3), 5);
		
		Map<Key , Integer> matrix2 = new LinkedHashMap<>();
		matrix2.put(new Key(0,0), 2);
		matrix2.put(new Key(0,2), 3);
		matrix2.put(new Key(2,0), 3);
		matrix2.put(new Key(2,2), 2);
		matrix2.put(new Key(2,3), 89);
		matrix2.put(new Key(3,2), 89);
		matrix2.put(new Key(3,3), 5);
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix2 = new SparseMatrix(4,5,matrix2);
		
		//Test For Addition
		sparseMatrix1.addSparseMatrix(sparseMatrix2);
		
	}
	
	/**
	 * Test Case for Sparse MAtrix Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestForMultiplication(){
		
		Map<Key , Integer> matrix1 = new LinkedHashMap<>();
		matrix1.put(new Key(0,0), 2);
		matrix1.put(new Key(0,2), 3);
		matrix1.put(new Key(2,0), 1);
		matrix1.put(new Key(2,2), 2);
		matrix1.put(new Key(2,3), 89);
		matrix1.put(new Key(3,1), 3);
		matrix1.put(new Key(3,3), 5);
		
		Map<Key , Integer> matrix2 = new LinkedHashMap<>();
		matrix2.put(new Key(0,0), 2);
		matrix2.put(new Key(0,2), 3);
		matrix2.put(new Key(2,0), 3);
		matrix2.put(new Key(2,2), 2);
		matrix2.put(new Key(2,3), 89);
		matrix2.put(new Key(3,2), 89);
		matrix2.put(new Key(3,3), 5);
		
		SparseMatrix sparseMatrix1 = new SparseMatrix(4,4,matrix1);
		SparseMatrix sparseMatrix2 = new SparseMatrix(5,5,matrix2);
		
		//Test For Multiplication
		sparseMatrix1.multiplySparseMatrix(sparseMatrix2);
		
	}

}
