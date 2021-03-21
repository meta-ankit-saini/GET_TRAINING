package Asssignment3_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * class implementing max heap data structure
 * @author ankit.saini_metacube
 *
 */
public class MaxHeap {
	private int capacity;
	private int size = 0;
	private Bowler[] heap;

	/**
	 * constructor to initialize heap with given capacity
	 * @param capacity
	 */
	public MaxHeap(int capacity) {
	   this.capacity = capacity;
	   this.heap = new Bowler[capacity];
	}
	
	/**
	 * method to compute index of left child
	 * @param parentIndex
	 * @return -> index of left child
	 */
	private int getLeftChildIndex(int parentIndex) {
	    return 2 * parentIndex + 1;
	}
	 
	/**
	 * method to compute index of right child
	 * @param parentIndex
	 * @return index of right child
	 */
	private int getRightChildIndex(int parentIndex) {
	    return 2 * parentIndex + 2;
	}
	
	/**
	 * method to compute index of parent 
	 * @param childIndex
	 * @return index of parent 
	 */
	private int getParentIndex(int childIndex) {
	    return (childIndex - 1) / 2;
	}
	
	/**
	 * method to find if index has left child
	 * @param index
	 * @return -> true if has else false
	 */
	private boolean hasLeftChild(int index) {
	    return getLeftChildIndex(index) < size;
	}
	
	/**
	 * method to find if index has right child
	 * @param index
	 * @return true if has else false
	 */
	private boolean hasRightChild(int index) {
	    return getRightChildIndex(index) < size;
	}
	
	/**
	 * method to find if index has parent
	 * @param index
	 * @return true if has else false
	 */
	private boolean hasParent(int index) {
	    return getParentIndex(index) >= 0;
	}
	
	/**
	 * method to fetch left child
	 * @param parentIndex
	 * @return -> left child
	 */
	private Bowler leftChild(int parentIndex) {
	    return heap[getLeftChildIndex(parentIndex)];
	}
	
	/**
	 * method to fetch right child
	 * @param parentIndex
	 * @return -> right child
	 */
	private Bowler rightChild(int parentIndex) {
	    return heap[getRightChildIndex(parentIndex)];
	}
	
	/**
	 * method to fetch parent
	 * @param childIndex
	 * @return -> parent
	 */
	private Bowler parent(int childIndex) {
	    return heap[getParentIndex(childIndex)];
	}
	
	/**
	 * method to compute if element is leaf element else false
	 * @param pos
	 * @return -> true if element is leaf element else false 
	 */
	private boolean isLeaf(int pos) { 
        return (!hasLeftChild(pos) && !hasRightChild(pos)); 
    } 
	
	/**
	 * method to swap two elements
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
	    Bowler element = heap[index1];
	    heap[index1] = heap[index2];
	    heap[index2] = element;
	}

	/**
	 * method to add element
	 * @param item
	 */
	public void add(Bowler item) {
	    ensureCapacity();
	    heap[size] = item;
	    size++;
	    heapifyUp();
	}
	
	/**
	 * method to ensure capacity
	 */
	private void ensureCapacity() {
	    if (size == capacity) {
	      heap = Arrays.copyOf(heap, capacity * 2);
	      capacity = capacity * 2;
	    }
	}

	/**
	 * method to fetch root element
	 * @return -> root
	 */
	public Bowler peek() {
	    if (size == 0) {
	      throw new NoSuchElementException();
	    }
	    return heap[0];
	}

	/**
	 * method to remove root element
	 * @return -> root
	 */
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
	
	/**
	 * method to heapify after poll
	 * @param pos
	 */
	private void maxHeapify(int pos) { 
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
  
	/**
	 * method to heapify after adding element
	 */
	private void heapifyUp() {
	    int index = size - 1;

	    while (hasParent(index) && parent(index).getNoOfBallsLeft() < heap[index].getNoOfBallsLeft()) {
	      swap(getParentIndex(index), index);
	      index = getParentIndex(index);
	    }
	}
	 
	/**
	 * method to print heap
	 */
	public void printHeap() {
	    for (int i = 0; i < size; i++) {
	      System.out.println("Bowler :  " + heap[i].getName() + "     Balls :    "  + heap[i].getNoOfBallsLeft());
	    }
	}
	 
	/**
	 * method to find 
	 * @return
	 */
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
