package Assignment6;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Marksheet {
	
	/**
	 * function to calculate average grade of students
	 * @param marksheet
	 * @param noOfStudents
	 * @param noOfSubjects
	 * @return -> an array containing average grades of all students
	 */
	public static Double[] averageGrade (int[][] marksheet, int noOfStudents , int noOfSubjects){
		Double[] averageGrade = new Double[noOfStudents];
		for (int i = 0; i < noOfStudents ; i++ ){
			averageGrade[i] = 0.0;
		}
		
		for (int i = 0; i < noOfStudents ; i++ ){
			for (int j = 0; j < noOfSubjects ; j++ ){
				averageGrade[i] += marksheet[i][j] ;
			}
			averageGrade[i] /= noOfSubjects;
		}
		return averageGrade;
	}
	
	/**
	 * Function to calculate maximum grade 
	 * @param marksheet
	 * @param noOfStudents
	 * @param noOfSubjects
	 * @param studentId
	 * @return -> a map containing student id and an array containing indexes of maximum grade
	 */
	public static LinkedHashMap< String , ArrayList<Integer> > maxGrade( int[][] marksheet, int noOfStudents , int noOfSubjects , String[] studentId){
		LinkedHashMap<String , ArrayList<Integer>> maxGradeLinkedHashMap = new LinkedHashMap<String , ArrayList<Integer>>();
		Integer marksOfMaxGrade;
		ArrayList<Integer> indexOfMaxGrade = new ArrayList<Integer>();
		for (int i = 0; i < noOfStudents ; i++ ){
			marksOfMaxGrade = -1;
			for (int j = 0; j < noOfSubjects ; j++ ){
				if ( marksheet[i][j] > marksOfMaxGrade) {
					marksOfMaxGrade = marksheet[i][j];
				}
			}
			for (int k = 0 ; k < noOfSubjects ; k++ ){
				if ( marksheet[i][k] == marksOfMaxGrade){
					indexOfMaxGrade.add(k);
				}
			}
			maxGradeLinkedHashMap.put(studentId[i], (ArrayList<Integer>) indexOfMaxGrade.clone());
			indexOfMaxGrade.clear();
		}
		return maxGradeLinkedHashMap;
	}
	
	/**
	 * function to calculate minimum grade
	 * @param marksheet
	 * @param noOfStudents
	 * @param noOfSubjects
	 * @param studentId
	 * @return a map containing student id and an array containing indexes of minimum grade
	 */
	public static LinkedHashMap< String , ArrayList<Integer> > minGrade( int[][] marksheet, int noOfStudents , int noOfSubjects , String[] studentId){
		LinkedHashMap<String , ArrayList<Integer>> minGradeLinkedHashMap = new LinkedHashMap<String , ArrayList<Integer>>();
		Integer marksOfMinGrade;
		ArrayList<Integer> indexOfMinGrade = new ArrayList<Integer>();
		for (int i = 0; i < noOfStudents ; i++ ){
			marksOfMinGrade = 101;
			for (int j = 0; j < noOfSubjects ; j++ ){
				if ( marksheet[i][j] < marksOfMinGrade) {
					marksOfMinGrade = marksheet[i][j];
				}
			}
			for (int k = 0 ; k < noOfSubjects ; k++ ){
				if ( marksheet[i][k] == marksOfMinGrade){
					indexOfMinGrade.add(k);
				}
			}
			minGradeLinkedHashMap.put(studentId[i], (ArrayList<Integer>) indexOfMinGrade.clone());
			indexOfMinGrade.clear();
		}
		return minGradeLinkedHashMap;
	}
	
	/**
	 * function to calculate percentage of student passed
	 * @param averageGrade
	 * @param minGrade
	 * @param noOfStudent
	 * @return -> Double representing percentage of student passed
	 */
	public static Double PercentageOfStudentPassed( Double[] averageGrade, Integer[] minGrade, int noOfStudent ){
		Double noOfPassedStudents = 0.0;
		for (int i = 0 ; i < noOfStudent ; i++ ){
			if (averageGrade[i] > 40.0 && minGrade[i] > 40.0 ){
				noOfPassedStudents += 1;
			}
		}
		return (double) ( noOfPassedStudents / noOfStudent * 100 ) ;	
	}
	
}
