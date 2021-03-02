package Assignment2;
import java.util.Scanner;

public class FCFS {
	
	/**
	 * function to compute completion time
	 * @param array
	 * @param noOfProcess
	 * @param completionTime
	 */
	public static void calculateCompletionTimeTime(int[][] array , int noOfProcess, int[] completionTime){
		for (int i = 0 ; i < noOfProcess ; i++){
			if (i == 0){
				completionTime[i] = array[i][0] + array[i][1];
			}
			else {
				if (array[i][0] > completionTime[i-1]){
					completionTime[i] = array[i][0] + array[i][1];
				}
				else {
					completionTime[i] = completionTime[i-1] + array[i][1];
				}
			}
//			System.out.println(completionTime[i]);
		}
		
	}
	
	/**
	 * function to compute TurnAround time
	 * @param array
	 * @param noOfProcess
	 * @param completionTime
	 * @param turnAroundTime matrix
	 */
	public static void calculateTurnAroundTime(int[][] array , int noOfProcess, int[] completionTime , int[] turnAroundTime){
		for (int i = 0; i < noOfProcess; i++){
			turnAroundTime[i] = completionTime[i] - array[i][0];
//			System.out.println(turnAroundTime[i]);
		}
		
	}
	
	/**
	 * function  to calculate waiting time
	 * @param array
	 * @param noOfProcess
	 * @param turnAroundTime
	 * @param waitingTime
	 */
	public static void calculateWaitingTime(int[][] array , int noOfProcess,  int[] turnAroundTime , int[] waitingTime){
		for (int i = 0; i < noOfProcess; i++){
			waitingTime[i] = turnAroundTime[i] - array[i][1];
//			System.out.println(waitingTime[i]);
		}
	}
	
	/**
	 * function to compute average waiting time
	 * @param noOfProcess
	 * @param waitingTime
	 * @return -> average waiting time
	 */
	public static float calculateAvgWaitingTime(int noOfProcess, int[] waitingTime){
		float average = 0;
		for(int i = 0 ; i < noOfProcess ; i++){
			average += waitingTime[i];
		}
		average /= noOfProcess;
		return average;
	}
	
	/**
	 * function for finding the maximum  waiting time
	 * @param noOfProcess
	 * @param waitingTime
	 * @return -> maximum waiting time
	 */
	public static int findMaximumWaitingTime(int noOfProcess, int[] waitingTime){
		int maxWaitingTime = 0;;
		for(int i = 0 ; i < noOfProcess ; i++){
			if(waitingTime[i] > maxWaitingTime){
				maxWaitingTime = waitingTime[i];
			}
		}
		return maxWaitingTime;
	
	}
	
	
	public static void main(String[] args){
		
	    Scanner scan = new Scanner(System.in); 
	    
	    System.out.println("Enter number of process in table: ");
	    int noOfProcess = scan.nextInt();
		
		int array[][]= new int[noOfProcess][2];
		int completionTime[] = new int[noOfProcess] , turnAroundTime[] = new int[noOfProcess] , waitingTime[] = new int[noOfProcess];
		
		
		
		System.out.println("Enter array with columns arrival time and burst time : ");
		enterMatrixData(scan, array, noOfProcess, 2);
		sortMatrixByArrivalTime(array, noOfProcess );
		
		System.out.println("Array after sorting in order of arrival time: ");
		printMatrix(array, noOfProcess, 2);
		
		calculateCompletionTimeTime(array , noOfProcess , completionTime);
		calculateTurnAroundTime(array , noOfProcess , completionTime , turnAroundTime);
		calculateWaitingTime(array, noOfProcess , turnAroundTime , waitingTime);
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %20s %20s %20s","Arival Time", "Burst Time", "Completion Time" , "TurnAround Time" , "Waiting Time" );
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0 ; i < noOfProcess ; i++) {
			System.out.printf("%20d %20d %20d %20d %20d",array[i][0] , array[i][1] , completionTime[i] , turnAroundTime[i] , waitingTime[i] );
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		
		
		
		System.out.println("Average Waiting Time : " + calculateAvgWaitingTime(noOfProcess, waitingTime));
		System.out.println("Maximum Waiting Time Period : " + findMaximumWaitingTime(noOfProcess, waitingTime));
	    
	   }
	
	/**
	 * function to take matrix input
	 * @param scan
	 * @param matrix
	 * @param matrixRow -> no of row in matrix
	 * @param matrixCol -> no of column in matrix
	 */
	public static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixCol){
		for (int i = 0; i < matrixRow; i++){
			for (int j = 0; j < matrixCol; j++){
				matrix[i][j] = scan.nextInt();
				}
	        }
	  	 }
	
	
	/**
	 * function to print a matrix
	 * @param matrix
	 * @param matrixRow
	 * @param matrixCol
	 */
	public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol){
		 for (int i = 0; i < matrixRow; i++){
			 for (int j = 0; j < matrixCol; j++){
				 System.out.print(matrix[i][j]+"\t");
		         }    
		     System.out.println();
		     }
		  }
	/**
	 * function to sort the matrix in order of arrival time
	 * @param matrix
	 * @param matrixRow -> no of row in matrix
	 */
	public static void sortMatrixByArrivalTime(int[][] matrix, int matrixRow){
		int tempForSort;
		 for (int i = 0; i < matrixRow; i++){
			 for (int j = 0; j < matrixRow-(i+1); j++){
				 if (matrix[j][0] > matrix[j+1][0]){
					 tempForSort = matrix[j][0];
					 matrix[j][0] = matrix[j+1][0];
					 matrix[j+1][0] = tempForSort;
					 tempForSort = matrix[j][1];
					 matrix[j][1] = matrix[j+1][1];
					 matrix[j+1][1] = tempForSort;
				 }
		     	 }    
		     }
		  }
	
}
