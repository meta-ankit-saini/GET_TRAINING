package Asssignment6_DSA;

import java.util.EnumMap;




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
	
	public EmployeeNode getHead(){
		return head;
	}
	
	public EmployeeNode getLast(){
		return last;
	}
	
//	public static void quickSort( EmployeeNode first, EmployeeNode last)
//	{
//	    if (first != null && last != null)
//	    {
//	        EmployeeNode pivot = partition( first, last) ;
//	        quickSort(list,first,pivot) ;
//	        quickSort(list,p.succ, last) ;
//	    }
//	    return list ;
//	}

	
	public EmployeeNode sortList(EmployeeNode head) {
        if (head == null || head.next == null) {
           return head;
       }
       return quickSort(head);
   }

   private EmployeeNode quickSort(EmployeeNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       // find mid as pivot
       EmployeeNode pivot = findMid(head);

       // dummy nodes 
       EmployeeNode leftDummy  = new EmployeeNode();
       EmployeeNode rightDummy = new EmployeeNode();
       EmployeeNode midDummy   = new EmployeeNode();
        
       EmployeeNode leftTail  = leftDummy;
       EmployeeNode rightTail = rightDummy;
       EmployeeNode midTail   = midDummy;
       
       // scan and partition
       while (head != null) {
           if (head.salary < pivot.salary) {
               leftTail.next = head;
               leftTail = leftTail.next;
           } else if (head.salary > pivot.salary) {
               rightTail.next = head;
               rightTail = rightTail.next;
           } else {
               midTail.next = head;
               midTail = midTail.next;
           }
           head = head.next;
       }
       
       // break links
       leftTail.next  = null;
       rightTail.next = null;
       midTail.next   = null;
       
       // sub sort
       EmployeeNode leftHead  = quickSort(leftDummy.next);
       EmployeeNode rightHead = quickSort(rightDummy.next);
       
       // concate
       EmployeeNode dummy = new EmployeeNode();
       EmployeeNode curr = dummy;
       if (leftHead != null) {
           curr.next = leftHead;
           curr = findTail(leftHead);
       }
       if (midDummy.next != null) {
           curr.next = midDummy.next;
           curr = midTail;
       }
       if (rightHead != null) {
           curr.next = rightHead;
       }
       
       // output
       return dummy.next;
   }
   
   private EmployeeNode findMid(EmployeeNode head) {
       EmployeeNode slow = head;
       EmployeeNode fast = head.next;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
   }
   
   private EmployeeNode findTail(EmployeeNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       while (head.next != null) {
           head = head.next;
       }
       return head;
   }
	
	
	
	
//	EmployeeNode paritionLast(EmployeeNode start, EmployeeNode end)
//    {
//        if (start == end || start == null || end == null)
//            return start;
// 
//        EmployeeNode pivot_prev = start;
//        EmployeeNode curr = start;
//        Double pivotSalary = end.salary;
//        int pivotAge = end.age;
////        Double pivot = end;
//        
//        // iterate till one before the end,
//        // no need to iterate till the end
//        // because end is pivot
//        while (start != end) {
//            if (start.salary > pivotSalary || (start.salary == pivotSalary && start.age > pivotAge )) {
//                // keep tracks of last modified item
//                pivot_prev = curr;
//                
////                if ()
////                EmployeeNode temp = curr;
////                curr = start;
////                start = temp
//                
//                Double tempSalary = curr.salary;
//                int tempAge = curr.age;
//                String tempId = curr.id;
//                
//                curr.salary = start.salary;
//                curr.age = start.age;
//                curr.id = start.id;
//                
//                start.salary = tempSalary;
//                start.age = tempAge;
//                start.id = tempId;
//                
//                curr = curr.next;
//            }
//            start = start.next;
//        }
// 
//        // swap the position of curr i.e.
//        // next suitable index and pivot
//        Double tempSalary = curr.salary;
//        int tempAge = curr.age;
//        String tempId = curr.id;
//        
//        curr.salary = start.salary;
//        curr.age = start.age;
//        curr.id = start.id;
//        
//        end.salary = tempSalary;
//        end.age = tempAge;
//        end.id = tempId;
//        
////        EmployeeNode temp = curr;
////        curr = pivot;
////        end = temp;
//       
//        
//        // return one previous to current
//        // because current is now pointing to pivot
//        return pivot_prev;
//    }
// 
//    void sort(EmployeeNode start, EmployeeNode end)
//    {
//        if(start == null || start == end|| start == end.next )
//            return;
// 
//        // split list and partion recurse
//        EmployeeNode pivot_prev = paritionLast(start, end);
//        sort(start, pivot_prev);
// 
//        if (pivot_prev != null && pivot_prev == start)
//            sort(pivot_prev.next, end);
// 
//        else if (pivot_prev != null
//                 && pivot_prev.next != null)
//            sort(pivot_prev.next.next, end);
//    }
    
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
		list.printEmployeeLinkList();
		EmployeeNode temp = list.sortList(list.getHead());
//		System.out.println("After Sorting");
//		list.printEmployeeLinkList();
	}
}
