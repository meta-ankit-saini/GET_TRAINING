package Asssignment6_DSA;

/**
 * class for creating adjacency list for graph
 * @author ankit.saini_metacube
 *
 */
public class GraphEdgeList {
	private GraphNode head , last;
	private int size = 0 ;
		
	public void insert(int edge , int weight){
		GraphNode node = new GraphNode(edge , weight);
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
	
	public GraphNode getHead(){
		return head;
	}
	
	/**
	 * method to get graph nodes array
	 * @return -> array of graph nodes
	 */
	public GraphNode[] getArrayOfGraphNodes(){
		GraphNode[] array = new GraphNode[size];
		int index = 0;
		GraphNode curr = head;
		while ( curr != null ) {
			GraphNode temp = new GraphNode(curr.edge , curr.weight);
			temp.next = curr.next;
			array[index] = temp;
			index += 1;
			curr = curr.next;
		}
		return array;
	}
	
	/**
	 * method to get graph edge array
	 * @return -> array of graph edge
	 */
	public int[] getEdgeArrayOfGraph(){
		int[] array = new int[size];
		int index = 0;
		GraphNode curr = head;
		while ( curr != null ) {
			array[index] = curr.edge;
			index += 1;
			curr = curr.next;
		}
		return array;
	}
}
