package Asssignment6_DSA;

import java.util.ArrayList;

/**
 * Interface for Graph Class
 * @author ankit.saini_metacube
 *
 */
public interface GraphInterface {
	public boolean isConnected();
	
	public ArrayList<Integer> reachable(Integer node);
	
	public void mst(Integer node);
	
	public void shortestPath(Integer node1 , Integer node2);
}
