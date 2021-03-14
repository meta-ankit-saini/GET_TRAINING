package Asssignment3_DSA;

public class ControllVirat {
	public static void main(String[] args) {
	    MaxHeap maxHeap = new MaxHeap(10);
	    maxHeap.add(new Bowler("Ankit", 5));
	    maxHeap.add(new Bowler("Amit", 7));	   
	    maxHeap.printHeap();
	    System.out.print(maxHeap.minRuns());
	  }
}
