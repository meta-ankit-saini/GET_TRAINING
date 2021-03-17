package Asssignment6_DSA;

/**
 * Class For Node of the Priority Queue
 * @author ankit.saini_metacube
 *
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
