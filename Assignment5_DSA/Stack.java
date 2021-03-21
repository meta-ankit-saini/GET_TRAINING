package Assignment2_DSA;

/**
 * Class implementing Stack
 * @author ankit.saini_metacube
 *
 * @param <T>
 */
public class Stack <T>{
	private Node top;
	private int size = 0;
	
	/**
	 * 
	 * @param data
	 */
	public void push(T data){
		Node node = new Node(data);
		size += 1;
		if (top == null ){
			top = node;
			return;
		}
		node.next = top;
		top = node;
	}
	
	/**
	 * 
	 * @return -> boolean if stack is empty else false
	 */
	public boolean isEmpty(){
		return (size == 0);
	}
	
	/**
	 * 
	 * @return -> length of stack
	 */
	public int length(){
		return size;
	}
	
	/**
	 * method to print stack 
	 */
	public void printStack(){
		if (size == 0){
			System.out.print("stack is empty");
			return ;
		}
		Node curr = top;
		while(curr != null){
			System.out.print(curr.data);
			curr = curr.next;
		}
	}
	
	/**
	 * method to remove last element of stack
	 * @return -> last element
	 */
	public T pop(){
		if (size == 0){
			new AssertionError("stack is empty");
		}
		size -= 1;
		T  temp = (T)top.data;
		top = top.next;
		return temp;
	}
	
	/**
	 * 
	 * @return -> last element of stack
	 */
	public T peek(){
		if (size == 0){
			new AssertionError("stack is empty");
		}
		T  temp = (T)top.data;
		return temp;
	}
}
