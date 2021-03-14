package Assignment2_DSA;

public class Queue<T> {
	Object [] queue ; 
	private int front , rear , size , capacity;
	
	public Queue(){
		capacity = 100;
		queue = new Object[capacity];
		front = -1;
		rear = -1; 
		size = 0;
	}
	
	public Queue(int capacity){
		this.capacity = capacity;
		queue = new Object[capacity];
		front = -1;
		rear = -1; 
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == capacity;
	}
	
	public int noOfElements(){
		return size;
	}
	
	public void enQueue(T data){
		if (isFull()){
			throw new AssertionError("No Space Available");
		}
		
		else if (front == -1 && rear == -1){
			front=0;  
	        rear=0;  
		}
		
		else {
			if (rear == capacity - 1){
				rear = 0;
			}
			else{
				rear = rear + 1;
			}
		}
		queue[rear] = data;
		size += 1;
	}
	
	
	public T deQueue(){
		if (isEmpty()){
			throw new AssertionError("Queue is Empty");
		}
		T temp = (T)queue[front];
		
		if (front == rear){
			front = -1;
			rear = -1;
		}
		else{
			if(front == capacity -1)
				front = 0;
			else
				front += 1;
		}
		size -= 1;
		return temp;
	}
	
	public void printQueue(){
		if(front == -1)
		{
			throw new AssertionError("Queue is Empty");
		}
		int frontPos = front,rearPos = rear;
		
		if( frontPos <= rearPos )
			while(frontPos <= rearPos)
			{
				System.out.print(queue[frontPos] + "   ");
				frontPos++;
			}
		else
		{
			while(frontPos <= capacity-1)
			{
				System.out.print(queue[frontPos] + "   ");
				frontPos++;
			}
			frontPos = 0;
			while(frontPos <= rearPos)
			{
				System.out.print(queue[frontPos] + "   ");
				frontPos++;
			}
		}
	}
	
}
