package Assignment8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * test class for NQueen
 * @author ankit.saini_metacube
 *
 */
public class NQueenTest {
	NQueen nQueen = new NQueen();
	/**
	 * method for creating board
	 * @param dimOfBoard
	 * @return matrix of dimOfBoard *  dimOfBoard
	 */
	public static int[][] createMatrixForQueenBoard(int dimOfBoard){
		int[][] board = new int[dimOfBoard][dimOfBoard];
		for(int row = 0 ; row < dimOfBoard ; row++ ){
			for(int col = 0 ; col < dimOfBoard ; col++){
				board[row][col] = 0;
			}
		}
		return board;
	}
	
	/**
	 * method for Testing nQueen method
	 */
	@Test
	public void test() {
		boolean result1 = nQueen.nQueen(createMatrixForQueenBoard(3), 0, 3);
		assertEquals(false, result1);
		
		boolean result2 = nQueen.nQueen(createMatrixForQueenBoard(4), 0, 4);
		assertEquals(true, result2);
		
		boolean result3 = nQueen.nQueen(createMatrixForQueenBoard(5), 0, 5);
		assertEquals(true, result3);
	}

}
