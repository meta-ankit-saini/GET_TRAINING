package Assignment1_DSA;

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
