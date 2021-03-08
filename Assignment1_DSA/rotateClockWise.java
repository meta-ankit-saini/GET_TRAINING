package Assignment1_DSA;


public class rotateClockWise {
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
	
	public void rotateLinkList(int L , int R , int N){
		
		if (head == null || head.next == null || N <= 0 ){
			return ;
		}
		
		if (N >= (R-L+1)){
			N = N % (R-L+1);
		}
		
		if (L > size || R > size) {
			System.out.println("Not Possible");
			return ;
		}
		
		int len = 1;
		Node beforeStartNode = null , startNode = null , afterEndNode = null , endNode = null , currNode = head;
		
		while(currNode != null || len == R ){
			if (L == 1 && len == 1 ){
				startNode = currNode;
			}
			if (len == L - 1 ){
				beforeStartNode = currNode;
				startNode = currNode.next;
			}
			if (len == R){
				endNode = currNode;
				afterEndNode = currNode.next;
			}
			len += 1;
			currNode = currNode.next;
		}

		endNode.next = startNode;
		int noOfRotation = R - L - N + 1;

		while( noOfRotation -- > 0){
			endNode = endNode.next; 
			startNode = startNode.next;
		}
	
		if (L != 1){
			beforeStartNode.next = startNode;
			endNode.next = afterEndNode;
		}
		else {
			head = startNode;
			endNode.next = afterEndNode;
		}
		
	}
	
	
	public static void main(String args[]){
		rotateClockWise list = new rotateClockWise();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.printLinkList();
		list.rotateLinkList(1, 5, 2);
		System.out.print("list after rotating ");
		list.printLinkList();
	}
}



