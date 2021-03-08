package Assignment1_DSA;

import java.util.Scanner;

/**
 * Class for Linked list rotation
 * @author ankit.saini_metacube
 *
 */
public class rotateClockWise {
	private Node head , last;
	private int size = 0;
	
	/**
	 * method for inserting element in Linked list
	 * @param data -> data of the Node
	 */
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
	 * method for computing size of linked list
	 * @return -> size of linked list
	 */
	public int sizeOfLinkList(){
		return size;
	}
	
	/**
	 * method for printing linked list
	 */
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
	
	/**
	 * method for rotating linked list clockwise from L to R , N times
	 * @param L -> left index
	 * @param R -> right index
	 * @param N -> no of rotation
	 */
	public void rotateLinkList(int L , int R , int N){
		
		if (head == null || head.next == null || N <= 0 ){
			return ;
		}
		
		// handling N > size of linked list
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
			//handling if left node is header condition
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
		
		//making linked list circular
		endNode.next = startNode;
		int noOfRotation = R - L - N + 1;

		//rotating the linked list
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
		Scanner scan = new Scanner(System.in); 
		rotateClockWise list = new rotateClockWise();
		
		System.out.println("enetr no of Elements : ");
		int noOfnodes = scan.nextInt() , data;
		
		for (int element = 0 ; element < noOfnodes ; element++) {
			data = scan.nextInt();
			list.insert(data);
		}
		
		list.printLinkList();
		
		System.out.println("enetr L : ");
		int L = scan.nextInt();
		System.out.println("enetr R : ");
		int R = scan.nextInt();
		System.out.println("enetr N : ");
		int N = scan.nextInt();
		
		list.rotateLinkList(L, R, N);
		System.out.print("list after rotating ");
		list.printLinkList();
	}
}



