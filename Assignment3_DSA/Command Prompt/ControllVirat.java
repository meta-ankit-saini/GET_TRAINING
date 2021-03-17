package Asssignment3_DSA;

public class ControllVirat {
	public static void main(String[] args) {
	    MaxHeap maxHeap = new MaxHeap(100);
	    maxHeap.add(new Bowler("Ankit", 5));
	    maxHeap.add(new Bowler("Amit", 7));	  
	    maxHeap.add(new Bowler("Ajay", 12));
	    maxHeap.add(new Bowler("Ajey", 13));
	    maxHeap.printHeap();
	    System.out.print(maxHeap.minRuns());
	  }
}
