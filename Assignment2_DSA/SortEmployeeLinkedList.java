package Asssignment5_DSA;


public class SortEmployeeLinkedList {
	private EmployeeNode head , last;
	private int size = 0;
	
	/**
	 * method for inserting element in Linked list
	 * @param data -> data of the Node
	 */
	public void insert(String id, Double salary , int age){
		EmployeeNode node = new EmployeeNode(id , salary , age);
		size += 1;
		if(head == null){
			head = node;
			last = node;
			return ;
		}
		last.next = node;
		last = last.next;
	}
	
	/**
	 * method for computing size of EMployee linked list
	 * @return -> size of linked list
	 */
	public int sizeOfEmployeeLinkList(){
		return size;
	}
	
	/**
	 * method for printing Employee linked list
	 */
	public void printEmployeeLinkList(){
		if (head == null){
			System.out.println("Empty List");
			return ;
		}
		EmployeeNode currNode = head;
		while (currNode != null){
			System.out.println("ID : " + currNode.id +"     Salary : " +  currNode.salary + "     Age : " +  currNode.age);
			currNode = currNode.next;
		}
	}
	
	
	public void sortEmployeeLinkedList(){
	    if (head == null || head.next == null) return ;
		EmployeeNode currNode = head ,sortedHead = null ;
		while(currNode != null){
			EmployeeNode currNext = currNode.next;
			sortedHead = sort(sortedHead , currNode);
			currNode = currNext;
		}
		head =  sortedHead;
	}
	
	public EmployeeNode sort(EmployeeNode sortedHead, EmployeeNode currNode){
		
		if(sortedHead == null || ( (sortedHead.salary < currNode.salary) || (sortedHead.salary.equals(currNode.salary) && (sortedHead.age > currNode.age) ) )){
			currNode.next = sortedHead;
			sortedHead = currNode;
		}
		else{
			EmployeeNode predNode = sortedHead;
			
			while(predNode.next != null &&((predNode.next.salary > currNode.salary) ||((predNode.next.salary.equals(currNode.salary)) && (predNode.next.age < currNode.age)) )  ){
					predNode = predNode.next;
			}
			currNode.next = predNode.next;
			predNode.next = currNode;
		
		}
		return sortedHead;
	}

	public static void main(String[] args){
		SortEmployeeLinkedList list = new SortEmployeeLinkedList();
		list.insert("A", 10000. ,20);
		list.insert("B", 12000. , 21);
		list.insert("C", 7000. ,22);
		list.insert("P", 8000., 19);
		list.insert("D", 8000. , 23);
		list.insert("E", 8000. , 24);
		list.insert("F", 8000. ,25);
		list.insert("G", 6000. ,21);
		list.insert("H", 13000. ,27);
		list.insert("Y", 8000. , 43);
		list.insert("Z", 8000. , 24);
		list.insert("P", 8000., 17);
		list.printEmployeeLinkList();
		list.sortEmployeeLinkedList();
		System.out.println("After Sorting");
		list.printEmployeeLinkList();
	}
}
