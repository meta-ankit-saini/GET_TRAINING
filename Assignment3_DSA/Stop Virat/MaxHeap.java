package Asssignment3_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
	private int capacity;
	private int size = 0;
	private Bowler[] heap;

	public MaxHeap(int capacity) {
	   this.capacity = capacity;
	   this.heap = new Bowler[capacity];
	}
	
	private int getLeftChildIndex(int parentIndex) {
	    return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
	    return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
	    return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
	    return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
	    return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
	    return getParentIndex(index) >= 0;
	}

	private Bowler leftChild(int parentIndex) {
	    return heap[getLeftChildIndex(parentIndex)];
	}

	private Bowler rightChild(int parentIndex) {
	    return heap[getRightChildIndex(parentIndex)];
	}

	private Bowler parent(int childIndex) {
	    return heap[getParentIndex(childIndex)];
	}
	
	private boolean isLeaf(int pos) { 
    
        return (!hasLeftChild(pos) && !hasRightChild(pos)); 
    } 
	
	private void swap(int index1, int index2) {
	    Bowler element = heap[index1];
	    heap[index1] = heap[index2];
	    heap[index2] = element;
	}

	  // Time Complexity : O( Log n)
	public void add(Bowler item) {
	    ensureCapacity();
	    heap[size] = item;
	    size++;
	    heapifyUp();
	}

	private void ensureCapacity() {
	    if (size == capacity) {
	      heap = Arrays.copyOf(heap, capacity * 2);
	      capacity = capacity * 2;
	    }
	}

	  // Time Complexity : O(1)
	public Bowler peek() {
	    if (size == 0) {
	      throw new NoSuchElementException();
	    }
	    return heap[0];
	}

	  // Time Complexity : O( Log n)
	public Bowler poll() {
	    if (size == 0) {
	      throw new NoSuchElementException();
	    }

	    Bowler element = heap[0];

	    heap[0] = heap[size - 1];
	    size--;
	    maxHeapify(0);
	    return element;
	}

	private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (heap[pos].getNoOfBallsLeft() < leftChild(pos).getNoOfBallsLeft() 
            || heap[pos].getNoOfBallsLeft() < rightChild(pos).getNoOfBallsLeft()) { 
  
            if (leftChild(pos).getNoOfBallsLeft() > rightChild(pos).getNoOfBallsLeft()) { 
                swap(pos, getLeftChildIndex(pos)); 
                maxHeapify(getLeftChildIndex(pos)); 
            } 
            else { 
                swap(pos, getRightChildIndex(pos)); 
                maxHeapify(getRightChildIndex(pos)); 
            } 
        } 
    } 
  
	 
	
	 private void heapifyUp() {
	    int index = size - 1;

	    while (hasParent(index) && parent(index).getNoOfBallsLeft() < heap[index].getNoOfBallsLeft()) {
	      swap(getParentIndex(index), index);
	      index = getParentIndex(index);
	    }
	 }
	 
	 public void printHeap() {
	    for (int i = 0; i < size; i++) {
	      System.out.println("Bowler :  " + heap[i].getName() + "     Balls :    "  + heap[i].getNoOfBallsLeft());
	    }
	 }
	 
	 public ArrayList<String>  minRuns(){
		 ArrayList<String> order = new ArrayList<String>();
		 while(peek().getNoOfBallsLeft() > 0){
			 Bowler bowler = this.poll();
			 order.add(bowler.getName());
			 this.add(new Bowler(bowler.getName(), bowler.getNoOfBallsLeft() - 1));
		 }
		 return order;
	 }
	 
}
