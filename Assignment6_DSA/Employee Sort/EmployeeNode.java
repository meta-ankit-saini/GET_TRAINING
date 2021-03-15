package Asssignment6_DSA;

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
