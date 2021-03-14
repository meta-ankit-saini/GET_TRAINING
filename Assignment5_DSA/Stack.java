package Assignment2_DSA;

public class Stack <T>{
	private Node top;
	private int size = 0;
	
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
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public int length(){
		return size;
	}
	
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
	
	public T pop(){
		if (size == 0){
			new AssertionError("stack is empty");
		}
		size -= 1;
		T  temp = (T)top.data;
		top = top.next;
		return temp;
	}
	
	public T peek(){
		if (size == 0){
			new AssertionError("stack is empty");
		}
		T  temp = (T)top.data;
		return temp;
	}
}
