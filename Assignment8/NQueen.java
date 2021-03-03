package Assignment8;

import java.util.Scanner;

/**
 * NQueen class for checking if it is possible to place queen in particular board
 * @author ankit.saini_metacube
 *
 */
public class NQueen {
	
	/**
	 * method to check if current position is safe to place queen
	 * @param board ->  A 2d matrix
	 * @param currRow -> Current Row Index 
	 * @param currRow -> Current Column Index
	 * @param dimOfBoard -> dimension of matrix
	 * @return -> boolean true if possible else false
	 */
	private static boolean iSSafe(int[][] board , int currRow , int currCol , int dimOfBoard){
		int row , col;
		
		//check for same column
		for( row = currRow-1 ; row >= 0 ; row--){
			if (board[row][currCol] == 1){
				return false;
			}
		}
		
		//check for upper left diagonal
		for( row = currRow , col = currCol ; row >= 0 && col >= 0 ; col -- , row --){
			if (board[row][col] == 1){
				return false;
			}
		}
		
		//check for upper right diagonal
		for( row = currRow , col = currCol ; row >= 0 && col < dimOfBoard ; col ++ , row --){
			if (board[row][col] == 1){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * to check if it is possiible place the queens on the board 
	 * @param board ->  A 2d matrix
	 * @param currRow -> Row Index to begin with
	 * @param dimOfBoard -> dimension of matrix
	 * @return -> boolean true if possible else false
	 */
	public boolean nQueen(int[][] board, int currRow  , int dimOfBoard  ){
		// Base Case -> successfully placed all queen
		if (currRow == dimOfBoard){
			return true;
		}
		
		// trying to place the queen in current row and call next by recursion
		for(int currCol = 0 ; currCol < dimOfBoard ; currCol ++ ){
			if(iSSafe(board, currRow, currCol, dimOfBoard)){
				//place the queen assuming right place
				board[currRow][currCol] = 1;
				
				//check if we can place the next queen 
				if (nQueen(board, currRow + 1, dimOfBoard)){
					return true;
				}
				
				//not right position
				board[currRow][currCol] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N;
		System.out.println("Enetr dimension of Board : ");
		N = scan.nextInt();
		int[][] board = new int[N][N];
		
		// initializing the board
	    for(int currRow = 0; currRow < N; currRow++)
	        for(int currCol = 0; currCol < N; currCol++)
	            board[currRow][currCol] = 0;
	    
	    NQueen q = new NQueen();
	    System.out.print("Is Possible to place queens : "+q.nQueen(board, 0, N));
	}
}



