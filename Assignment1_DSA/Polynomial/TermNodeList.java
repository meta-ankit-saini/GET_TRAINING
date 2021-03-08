package Assignment1_DSA;

public class TermNodeList {
	public TermNode head , last;
	public int size = 0;
	
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
	
	public TermNode getHead(){
		return head;
	}
	
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
