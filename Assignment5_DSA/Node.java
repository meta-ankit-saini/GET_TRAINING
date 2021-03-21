package Assignment2_DSA;

/**
 * Class for Node Structure for Stack
 * @author ankit.saini_metacube
 *
 * @param <T>
 */
public class Node<T> {
	Object data;
	Node next;
	public Node(T data){
		this.data = data;
		next = null;
	}
}
