package Assignment1_DSA;

/**
 * class for loop detection in linked list
 * @author ankit.saini_metacube
 *
 */
public class DetectLopp {
	/**
	 * method for loop detection
	 * @param head -> header of linked list
	 * @return -> true if loop detected
	 */
	public static boolean detectloop(Node head){
		if(head == null || head.next == null){
			return false;
		}
		Node slowNode = head , fastNode = head;
		while (fastNode != null){
			
			slowNode = slowNode.next;
			if (fastNode.next == null){
				return false;
			}
			else{
				fastNode = fastNode.next.next;
			}

			if (slowNode == fastNode){
				return true; 
			}
		}
		return false;
	}
	

	
	public static void main(String args[]){
		Node head = new Node(1);
		Node node2 = new Node(2);
		head.next = node2;
		Node node3 = new Node(3);
		node2.next = node3; 
		Node node4 = new Node(4);
		node3.next = node4; 
		Node node5 = new Node(5);
		node4.next = node5; 
		Node node6 = new Node(6);
		node5.next = node6; 
		Node node7 = new Node(7);
		node6.next = node7; 
		Node node8 = new Node(8);
		node7.next = node8;
		node8.next = node3;
		if(detectloop(head)){
			System.out.print("Detected");
		}
		else{
			System.out.print("No Loop Detected");
		}
	
	}
}
