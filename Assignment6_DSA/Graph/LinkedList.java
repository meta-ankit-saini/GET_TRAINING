package Asssignment6_DSA;


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
		
	public int sizeOfLinkList(){
		return size;
	}
	
	public Node getHead(){
		return head;
	}
	
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

