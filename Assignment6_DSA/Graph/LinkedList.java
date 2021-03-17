package Asssignment6_DSA;

/**
 * Linked List For Quick Sort
 * @author ankit.saini_metacube
 *
 */
public class LinkedList {
	private Node head , last;
	private int size = 0;
		
	public void insert(int data){
		Node node = new Node(data);
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
	 * 
	 * @return -> size of the link List
	 */
	public int sizeOfLinkList(){
		return size;
	}
	
	/**
	 * 
	 * @return -> head pf the link list
	 */
	public Node getHead(){
		return head;
	}
	
	/**
	 * print Linked List
	 */
	public void printList(){
		if(head == null){
			return;
		}
		Node node = head;
		while (node != null){
			System.out.print(node.data+"->");
			node = node.next;
		}
	}
	
}

