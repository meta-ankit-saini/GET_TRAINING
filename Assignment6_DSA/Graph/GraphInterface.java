package Asssignment6_DSA;

import java.util.ArrayList;

public interface GraphInterface {
	public boolean isConnected();
	
	public ArrayList<Integer> reachable(Integer node);
	
	public void mst(Integer node);
	
	public void shortestPath(Integer node1 , Integer node2);
}
