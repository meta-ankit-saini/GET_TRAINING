package Asssignment6_DSA;
public class PriorityQueue{
	PriorityNode[] priorityQueue; 
	private int front , rear , size , capacity;
	
	public PriorityQueue(){
		capacity = 100;
		priorityQueue = new PriorityNode[capacity];
		front = -1;
		rear = -1; 
		size = 0;
	}
	
	public PriorityQueue(int capacity){
		this.capacity = capacity;
		priorityQueue = new PriorityNode[capacity];
		front = -1;
		rear = -1; 
		size = 0;
	}
	
	public PriorityNode peek(){
		return priorityQueue[rear];
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
	
	public void enQueue(PriorityNode data){
		if (isFull()){
			throw new AssertionError("No Space Available");
		}
		
		else if (front == -1 && rear == -1){
			front=0;  
	        rear=0;  
	        priorityQueue[rear] = data;
		}
		
		else{
            int pos = -1;
            if(this.front <= rear){
            	for(int index = front; index<= rear ; index++){
                	if(data.getPriority() > priorityQueue[index].getPriority()){
                		pos = index;
                		break;
                	}
                }
            	if(pos != -1){
                    for(int index = this.rear; index >= pos; index--)	{
                    	priorityQueue[(index + 1) % capacity] = priorityQueue[index];
                    }
                    priorityQueue[pos] = data;
                    rear = (rear + 1) % capacity;
                }
                else{
                rear = (rear + 1) % capacity;
                	priorityQueue[rear] = data;   
                }
            }	
            else{
            	for(int index = front; index<= capacity - 1; index++){
                	if(data.getPriority() > priorityQueue[index].getPriority()){
                		pos = index;
                		break;
                	}
                }
            	if(pos == -1){
            		for(int index = 0; index <= rear; index++){
                    	if(data.getPriority() > priorityQueue[index].getPriority()){
                    		pos = index;
                    		break;
                    	}
                    }
            	}
            	if(pos != -1){
                    for(int index = this.rear; index>= pos && index >=0 ; index--)	{
                    	priorityQueue[(index + 1) % capacity] = priorityQueue[index];
                    }
                    for(int index = pos; index <= capacity -1 ; index--)	{
                    	priorityQueue[(index + 1) % capacity] = priorityQueue[index];
                    }
                    rear = (this.rear + 1) % capacity;
                    priorityQueue[pos] = data;
                }
                else{
                	rear = (rear + 1) % capacity;
                	priorityQueue[rear] = data;   
                }
            }
        }
		size += 1;
	}
	
	public PriorityNode deQueue(){
		if (isEmpty()){
			throw new AssertionError("Queue is Empty");
		}
		PriorityNode temp = priorityQueue[front];
		
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
				System.out.print(priorityQueue[frontPos].getPriority() + "   ");
				frontPos++;
			}
		else
		{
			while(frontPos <= capacity-1)
			{
				System.out.println(priorityQueue[frontPos].getPriority() + "   ");
				frontPos++;
			}
			frontPos = 0;
			while(frontPos <= rearPos)
			{
				System.out.println(priorityQueue[frontPos].getPriority() + "   ");
				frontPos++;
			}
		}
	}
}
