package Asssignment6_DSA;

import java.util.ArrayList;

/**
 * Interface for Graph Class
 * @author ankit.saini_metacube
 *
 */
public interface GraphInterface {
	/**
	 * method to check if graph is connected or not
	 * @return -> true if graph is connected else false
	 */
	public boolean isConnected();
	
	/**
	 * method to find out reachable nodes from a particular node
	 * @param node
	 * @return -> ArrayList of reachable nodes
	 */
	public ArrayList<Integer> reachable(Integer node);
	
	/**
	 * method to print minimum spanning tree of graph
	 * @param node
	 */
	public void mst(Integer node);
	
	/**
	 * method to print shortest path between two nodes of graph
	 * @param node
	 */
	public void shortestPath(Integer node1 , Integer node2);
}
