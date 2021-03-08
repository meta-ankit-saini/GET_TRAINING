package Assignment1_DSA;

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
