package Asssignment3_DSA;

/**
 * Class  for node of priority queue contains priority with every data point
 * @author ankit.saini_metacube
 * @param <T>
 */
public class PriorityNode<T> {

	private Object data;
	private final int priority;
		
		
	public PriorityNode(T data, int priority) {	
		this.data = data;
		this.priority = priority;
	}

	
	public T getData() {
		return (T) data;
	}

	public int getPriority() {
		return priority;
	}
		
}
