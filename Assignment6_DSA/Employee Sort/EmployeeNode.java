package Asssignment6_DSA;
/**
 * Class for the Node of LinkedList 
 * @author ankit.saini_metacube
 *
 */
public class EmployeeNode {
	int age;
	Double salary;
	String id;
	EmployeeNode next;
	
	public EmployeeNode(String id , Double salary , int age) {
		this.id = id;
		this.age = age;
		this.salary = salary;
		next = null;
	}
}
