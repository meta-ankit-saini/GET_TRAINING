package Asssignment4_DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class for creating collection of employee
 * @author ankit.saini_metacube
 *
 */
public class EmployeeOperation {
	
	/**
	 * method to print employee collection
	 * @param employeeCollection
	 */
	public static void printEmployeesListCollection(ArrayList<Employee> employeeCollection){
		if(employeeCollection.size() == 0){
			System.out.println("Collection is empty");
			return;
		}
		else{
			System.out.println("Employee Id     Last Name       Address");
			for(Employee employee : employeeCollection){
				System.out.println(employee.getEmpployeeId() + "               " + employee.getName() + "       	" + employee.getAddress());
			}
		}
	}
	
	/**
	 * method to sort collection by id 
	 * @param employeeCollection
	 */
	public static void sortCollectionByNaturalOrder(ArrayList<Employee> employeeCollection){
		class EmployeeIdComparator implements Comparator<Employee>{
			@Override
			public int compare(Employee employee1, Employee employee2){
				return employee1.getEmpployeeId() - employee2.getEmpployeeId();
			}
		}
		Collections.sort((List<Employee>) employeeCollection , new EmployeeIdComparator() );
	}
	
	/**
	 * method to sort collection by name
	 * @param employeeCollection
	 */
	public static void sortCollectionByEmployeeName(ArrayList<Employee> employeeCollection){
		class EmployeeNameComparator implements Comparator<Employee>{
			@Override
			public int compare(Employee employee1, Employee employee2){
				return employee1.getName().compareTo(employee2.getName());
			}
		}
		Collections.sort((List<Employee>) employeeCollection , new EmployeeNameComparator() );
	}
	
	/**
	 * method to remove duplicate elements
	 * @param employeeCollection
	 * @return
	 */
	public static Set<Employee> createEmployeeSet(ArrayList<Employee> employeeCollection){
		Set<Employee> set = new HashSet<Employee> (); 
		for(Employee employee : employeeCollection)
			set.add(employee);
		return set;
	}
	
	public static void main(String[] args){
		ArrayList<Employee> employeeCollection = new ArrayList<Employee>();
		Employee employee1 = new Employee(3, "Ankit",  "Udaipur");
		Employee employee2 = new Employee(2, "Amit",  "Jaisalmer");
		Employee employee3 = new Employee(5, "Ajayt", "Delhi");
		Employee employee4 = new Employee(1, "Aadarsh", "Dausa");
		Employee employee5 = new Employee(4, "Aakash", "Jaipur");
		Employee employee6 = new Employee(4, "Abhay", "Jaipur");
		employeeCollection.add(employee1);
		employeeCollection.add(employee2);
		employeeCollection.add(employee3);
		employeeCollection.add(employee4);
		employeeCollection.add(employee5);
		employeeCollection.add(employee6);
		printEmployeesListCollection(employeeCollection);
		System.out.println();
		
		sortCollectionByNaturalOrder(employeeCollection);
		printEmployeesListCollection(employeeCollection);
		System.out.println();
		
		sortCollectionByEmployeeName(employeeCollection);
		printEmployeesListCollection(employeeCollection);
		System.out.println();
		
		Set<Employee> set = createEmployeeSet(employeeCollection);
		System.out.println("emplyee list after setifying : ");
		System.out.println("Employee Id     Last Name       Address");
		for(Employee employee : set){
			System.out.println(employee.getEmpployeeId() + "               " + employee.getName() + "       	" + employee.getAddress());
		}
	}
}
