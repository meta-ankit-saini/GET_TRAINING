package Assignment1_DSA;

/**
 * main class for storing polynomial data, stores the current term with coefficient and address of next term  
 * @author ankit.saini_metacube
 *
 */
public class PolyNode {
	public int coeff;
	public PolyNode next;
	public TermNodeList termNodeList;
	
	public PolyNode(int coeff ){
		this.coeff = coeff;
		this.termNodeList = null;
		this.next = null;
	}
}
