package Assignment1_DSA;

/**
 * class for storing and accessing TermNode
 * @author ankit.saini_metacube
 *
 */
public class TermNodeList {
	public TermNode head , last;
	public int size = 0;
	
	/**
	 * inserts variable with degree
	 * @param var
	 * @param degree
	 */
	public void insert(char var ,int degree){
		TermNode termNode = new TermNode(var ,degree);
		size += 1;
		if(head == null){
			head = termNode;
			last = termNode;
			return ;
		}
		last.next = termNode;
		last = last.next;
	}
	
	/**
	 * @return -> header of the term
	 */
	public TermNode getHead(){
		return head;
	}
	
	/**
	 * method for printing printing 
	 */
	public void printTermNode(){
		if (head == null){
			System.out.println(" ");
			return ;
		}
		TermNode currNode = head;
		while (currNode != null){
			System.out.print(currNode.var+"^"+currNode.degree);
			currNode = currNode.next;
		}
	}
}
