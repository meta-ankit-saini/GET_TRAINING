package Asssignment6_DSA;

public class LinkedListQuickSort {
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
	
	/**
	 * 
	 * @return -> head of linked list
	 */
	public EmployeeNode getHead(){
		return head;
	}
	
	/**
	 * 
	 * @return -> last of linked list
	 */
	public EmployeeNode getLast(){
		return last;
	}
	
	/**
	 * helper method for quick sort -> replaces head to head of sorted list   
	 */
	public void sortList() {
        head = sort(head);
    }
    
	/**
	 * perform quick sort
	 * @param head
	 * @return
	 */
    private EmployeeNode sort(EmployeeNode head) {
        if (head == null) return null;
        EmployeeNode leftHead = new EmployeeNode(null,1000000.,10000), midHead = new EmployeeNode(null,1000000.,10000), rightHead = new EmployeeNode(null,1000000.,10000);
        EmployeeNode leftTail = leftHead, midTail = midHead, rightTail = rightHead;
        EmployeeNode cur = head;
        while(cur != null) {
            if (cur.salary > head.salary || ((cur.salary.equals(head.salary)) && (cur.age < head.age))) {
                leftTail.next = cur;
                leftTail = leftTail.next;
            } else if (cur.salary == head.salary) {
                midTail.next = cur;
                midTail = midTail.next;
            } else {
                rightTail.next = cur;
                rightTail = rightTail.next;
            }
            cur = cur.next;
        }
        leftTail.next = rightTail.next = midTail.next = null;
        leftHead.next = sort(leftHead.next);
        rightHead.next = sort(rightHead.next);
        findTail(leftHead).next = midHead.next;
        findTail(leftHead).next = rightHead.next;
        return leftHead.next;
    }
    
    /**
     * method to find tail of linked list
     * @param head
     * @return
     */
    private EmployeeNode findTail(EmployeeNode head) {
        while(head != null && head.next != null) {
            head = head.next;
        }
        return head;
    }
	  
    public static void main(String[] args){
		LinkedListQuickSort list = new LinkedListQuickSort();
		list.insert("A", 10000. ,20);
		list.insert("B", 12000. , 21);
		list.insert("C", 7000. ,22);
		list.insert("P", 8000., 19);
		list.insert("D", 8000. , 23);
		list.insert("E", 8000. , 24);
		list.insert("F", 8000. ,25);
		list.insert("G", 6000. ,26);
		list.insert("H", 13000. ,27);
		list.insert("Y", 8000. , 43);
		list.insert("Z", 8000. , 24);
		list.insert("P", 8000., 17);
		list.insert("K", 8000. ,25);
		list.printEmployeeLinkList();
		list.sortList();
		System.out.println("After Sorting");
		list.printEmployeeLinkList();
	}
}
