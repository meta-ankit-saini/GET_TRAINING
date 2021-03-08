package Assignment1_DSA;

public class LinkList {
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
	
	public void printLinkList(){
		if (head == null){
			System.out.println("Empty List");
			return ;
		}
		Node currNode = head;
		while (currNode != null){
			System.out.println(currNode.data);
			currNode = currNode.next;
		}
	}
	
	public static void main(String args[]){
		LinkList list = new LinkList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.printLinkList();
	}
}
