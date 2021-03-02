package Assignment6;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainMarksheet {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int noOfStudents,noOfSubjects;
		
		System.out.println("Enter No Of Subjects : ");
		noOfSubjects = scan.nextInt();
		String[] subjects = new String[noOfSubjects];
		
		System.out.println("Enter Name Of Subjects : ");
		for (int i = 0; i < noOfSubjects ; i++ ){
			subjects[i] = scan.next();
		}
		
		System.out.println("Enter No Of Students : ");
		noOfStudents = scan.nextInt();		
		String[] studentsId = new String[noOfStudents];		
		
		System.out.println("Enter Name Of Students : ");
		for (int i = 0; i < noOfStudents ; i++ ){
			studentsId[i] = scan.next();
		}
		
		int[][] marksheet = new int[noOfStudents][noOfSubjects];
		
		for (int i = 0; i < noOfStudents ; i++ ){
			System.out.printf("Enter marks of different Subjects for student %d : ",i);
			for (int j = 0; j < noOfSubjects ; j++ ){
				marksheet[i][j] = scan.nextInt();
			}
			System.out.println();
		}
		
		
		Double[] avgGrade = new Double[noOfStudents];
		avgGrade = Marksheet.averageGrade(marksheet, noOfStudents, noOfSubjects);
		
		for (int i = 0; i < noOfStudents ; i++ ){
			System.out.println(avgGrade[i]);
		}
		
		LinkedHashMap<String , ArrayList<Integer>> maxGradeLinkedHashMap = Marksheet.maxGrade(marksheet, noOfStudents, noOfSubjects , studentsId);
		LinkedHashMap<String , ArrayList<Integer>> minGradeLinkedHashMap = Marksheet.minGrade(marksheet, noOfStudents, noOfSubjects , studentsId);
		
		System.out.println(maxGradeLinkedHashMap);
		System.out.println(minGradeLinkedHashMap);
		System.out.println(minGradeLinkedHashMap.values());
		
		Integer[] minGrade = new Integer[noOfStudents];
		int ind = 0;
		
		for ( ArrayList<Integer> item :  minGradeLinkedHashMap.values()){
			minGrade[ind] = marksheet[ind][item.get(0)];
			ind += 1;
		}
		System.out.println(Marksheet.PercentageOfStudentPassed(avgGrade, minGrade, noOfStudents));
	}
}
