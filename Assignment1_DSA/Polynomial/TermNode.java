package Assignment1_DSA;

/**
 * sub class for PolyNode and for storing information about variable in a term of polynomial 
 * @author ankit.saini_metacube
 *
 */
public class TermNode {
	public char var;
	public int degree;
	public TermNode next;
	
	public TermNode(char var , int degree){
		this.var = var;
		this.degree = degree;
		this.next = null;
	}
}
