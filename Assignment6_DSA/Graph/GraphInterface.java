package Asssignment6_DSA;

import java.util.ArrayList;

public interface GraphInterface {
	public boolean isConnected();
	
	public ArrayList<Integer> reachable(Integer node);
	
	public int[] mst(Integer node);
	
	public int[] shortestPath(Integer node1 , Integer node2);
}
