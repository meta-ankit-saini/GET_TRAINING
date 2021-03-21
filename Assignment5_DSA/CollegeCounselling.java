package Assignment2_DSA;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;   
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CollegeCounselling {
	
	/**
	 * method to read Excel file in XSSFSheet format
	 * @param path -> path of excel file
	 * @return -> XSSFsheet 
	 */
	public XSSFSheet readExcelFile(String path ) {
		FileInputStream fileInputStream;
		try {
				fileInputStream = new FileInputStream(path);
			} 
		catch (FileNotFoundException e) {
				throw new AssertionError("File not Found : ");
		}	
		XSSFWorkbook workbook = null;
		try {	
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			throw new AssertionError("Input Ouput Exception");
		}
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		return sheet;
	}
	
	/**
	 * method to get Program Map containing program and capacity
	 * @param programPath
	 * @return -> LinkedHashMap<program, capacity> 
	 */
	public LinkedHashMap<String, Integer> getProgramMap(String programPath){
		LinkedHashMap<String, Integer> programMap = new LinkedHashMap<String, Integer>();
		XSSFSheet  programSheet = readExcelFile(programPath);
		String programName = null;
		int capacity = 0 , rowNumber = 0 ,colNumber = 0;
		for(Row row : programSheet){
			colNumber = 0;
			if(rowNumber > 0){
				for(Cell  cell : row){
					if(colNumber == 0){
						programName = cell.getStringCellValue().trim();
					}
					else if(colNumber == 1){
						capacity = (int)cell.getNumericCellValue();
					}
					colNumber++;
				}
				programMap.put(programName, capacity);
			}			
			rowNumber++;
		}
		return programMap;
	}
	
	/**
	 * method to get student map containing student and choices
	 * @param studentPath
	 * @return -> LinkedHashMap<Student, ArrayList<choice>>
	 */
	public LinkedHashMap<String, ArrayList<String>> getStudentMap(String studentPath){
		LinkedHashMap<String, ArrayList<String>> studentMap = new LinkedHashMap<String, ArrayList<String>>();
		XSSFSheet  studentSheet = readExcelFile(studentPath);
		int rowNumber = 0 ,colNumber = 0;
		for(Row row : studentSheet){
			colNumber = 0;
			String studentName = null;
			ArrayList<String> programs = new ArrayList<String>();
			for(Cell  cell : row){
				if(colNumber == 0){
					studentName = cell.getStringCellValue().trim();
				}
				else{
					programs.add(cell.getStringCellValue().trim());
				}
				colNumber++;
			}
			if (rowNumber > 0 && !studentName.equals("") ){	
				studentMap.put(studentName,programs );
			}	
			rowNumber++;
		}
		return studentMap;
	}
	
	/**
	 * method to add students in Queue 
	 * @param studentPath
	 * @return
	 */
	public Queue<Student> addStudentsInQueue(String studentPath){
		LinkedHashMap<String, ArrayList<String>> studentMap = getStudentMap(studentPath);
		Queue<Student> studentQueue = new Queue<Student>(studentMap.size());
		for (String studentName : studentMap.keySet()){
			studentQueue.enQueue(new Student(studentName,studentMap.get(studentName)));
		}
		return studentQueue;
	}
	
	/**
	 * method to compute allocations for student
	 * @param programPath
	 * @param studentPath
	 * @param allocationPath
	 * @return
	 */
	public LinkedHashMap<String, ArrayList<String>> getAllocationMap(String programPath , String studentPath, String allocationPath ){
		Queue<Student> studentQueue = addStudentsInQueue(studentPath);
		LinkedHashMap<String, Integer> programMap = getProgramMap(programPath);
		
		LinkedHashMap<String, ArrayList<String>> allocationMap = new LinkedHashMap<String, ArrayList<String>>();
		
		while(!studentQueue.isEmpty()){
			Student student = studentQueue.deQueue();
			ArrayList<String> programs = student.getList();
			ArrayList<String> allocatedPrograms = new ArrayList<String>();
			for(String program : programs){
				if(programMap.get(program) > 0){
					allocatedPrograms.add(program);
					programMap.put(program,programMap.get(program)-1);
				}
				else {
					allocatedPrograms.add(" ");
				}
			}
			allocationMap.put(student.getName(),allocatedPrograms);
		}
		return allocationMap;
	}
	
	/**
	 * method to write allocation in allocations file
	 * @param programPath
	 * @param studentPath
	 * @param allocationPath
	 */
	public void writeAllocationToExcelFile(String programPath , String studentPath, String allocationPath){
		LinkedHashMap<String, ArrayList<String>>  allocationMap = getAllocationMap(programPath, studentPath, allocationPath);
		XSSFWorkbook allocationWorkbook = new XSSFWorkbook();
		XSSFSheet allocationSheet = allocationWorkbook.createSheet("Allocations");
		
	
		
		Row titleRow = allocationSheet.createRow(0);
		String[] allocatedPrograms = { "Name" ,"Preference1", "Preference2", "Preference3", "Preference4", "Preference5"};
		for(int index = 0 ; index < allocatedPrograms.length ; index++){
			titleRow.createCell(index).setCellValue(allocatedPrograms[index]);
		}
		
		int rowNumber = 1 ;
		
		for (String name : allocationMap.keySet()){
			Row tempRow = allocationSheet.createRow(rowNumber);
			Cell tempNameCell = tempRow.createCell(0);
			tempNameCell.setCellValue(name);
			Object[] programs = allocationMap.get(name).toArray();
			for(int index = 1 ; index < allocatedPrograms.length ; index++){
				tempRow.createCell(index).setCellValue((String)programs[index-1]);
			}
			rowNumber += 1;
		}
		for(Row row : allocationSheet){
			for(Cell  cell : row){
				System.out.println(cell.getStringCellValue());
			}	
		}
		
		try {
			FileOutputStream outputStream = new FileOutputStream(allocationPath);
			allocationWorkbook.write(outputStream);
		} 
		catch (Exception e) {
			throw new AssertionError("Error in Creating Output File");
		}
	}
	
	
	
	public static void main(String[] args){
		String programPath = ".\\data\\Programs.xlsx" ;
		String studentPath = ".\\data\\Students.xlsx"; 
		String allocationPath = ".\\data\\Allocations.xlsx";
		CollegeCounselling c = new CollegeCounselling();
		c.writeAllocationToExcelFile(programPath, studentPath, allocationPath);
	}
	
}
