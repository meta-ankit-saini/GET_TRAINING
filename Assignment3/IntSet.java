package Assignment3;

import java.util.ArrayList;


public class IntSet {
	private final ArrayList<Integer> set;
	private final int upperBound = 1000;
	private final int lowerBound = 1;
	
	/**
	 * constructor for initializing set
	 * @param array
	 */
	public IntSet(Integer array[]){
		ArrayList<Integer> tempSet = new ArrayList<Integer>();
		
		for (int dataOfArray : array){
			if (!tempSet.contains(dataOfArray)){
				tempSet.add(dataOfArray);
			}
		}
		this.set = tempSet;	
	}
	
	/**
	 * method for printing data of set
	 */
	public void PrintIntSet(){
		for (int data : set){
			System.out.println(data);
		}
	}
	
	/**
	 * method for checking if data is present in set or not
	 * @param data
	 * @return boolean 
	 */
	public boolean isMember(int data){
		if ( data < lowerBound && data > upperBound) {
			return false;
		}
		return set.contains(data);
		
	}
	
	/**
	 * method for calculating size of set
	 * @return -> integer representing size of array
	 */
	public int size() {
		return this.set.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> iterator(){
		return (ArrayList<Integer>) this.set.clone();
	}
	
	/**
	 * method for checking if given set is subset or not
	 * @param anotherSet
	 * @return -> boolean representing if given set is  subset or not
	 */
	public boolean isSubset(IntSet anotherSet){
		for (int data : anotherSet.iterator()){
			if (!isMember(data)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * method for computing union
	 * @param anotherSet
	 * @return -> union IntSet
	 */
	public IntSet union( IntSet anotherSet ){
		Integer unionArray[] = new Integer[ this.size() + anotherSet.size()];
		int ind = 0;
		
		for (int data : this.set ){
			unionArray[ind++] = data;
		}
		
		for (int data : anotherSet.iterator()){
			unionArray[ind++] = data;
		}
		
		return new IntSet(unionArray);
	}
	
	/**
	 * method for calculating complement set 
	 * @return compliment IntSet
	 */
	public IntSet getCompliment( ){
		ArrayList<Integer> tempComplimentSet = new ArrayList<Integer>();
		
		for (int i = lowerBound ; i <= upperBound ; i++ ){
			tempComplimentSet.add(i);
		}
		
		for (int data : set){
			tempComplimentSet.remove(new Integer(data));
		}
		return new IntSet( tempComplimentSet.toArray(new Integer[0]) );
	}

}
