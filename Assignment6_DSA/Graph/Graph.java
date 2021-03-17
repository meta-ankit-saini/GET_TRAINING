package Asssignment6_DSA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to perform operation on graph
 * @author ankit.saini_metacube
 *
 */
public class Graph implements GraphInterface{
	private GraphEdgeList[] edgeList;
	private boolean[] visited;
	private int[] dist;
	private PriorityQueue pQueue;
	private LinkedList[]  path;
	private int[] prims;
	
	public Graph(GraphEdgeList[] edgeList ){
		this.edgeList = edgeList;
		visited = new boolean[edgeList.length];
		dist = new int[edgeList.length];
		prims = new int[edgeList.length];
		pQueue = new PriorityQueue();
		path = new LinkedList[edgeList.length];
	}
	
	/**
	 * function for depth first search traversal
	 * @param node -> current node position
	 */
	public void dfs(int node){
		visited[node] = true;
		for (int child : edgeList[node].getEdgeArrayOfGraph())
			if(!visited[child])
				dfs(child);
	}
	
	/**
	 * function to count no of connected components
	 * @return -> no of connected components
	 */
	public int connectedCompenents() {
		int cc = 0;
		for (int index = 1 ; index < visited.length ; index++){
			visited[index] = false;
		}
		for (int index = 1 ; index < visited.length ; index++){
			if (!visited[index]){
				dfs(index);
				cc++;
			}
		}
		
		return cc;
	}
	
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		for (int index = 1 ; index < visited.length ; index++){
			visited[index] = false;
		}
		dfs(1);
		for (int index = 1 ; index < visited.length ; index++){
			if (visited[index] == false)
				return false;
		}
		return true;
	}

	
	@Override
	public ArrayList<Integer> reachable(Integer node) {
		// TODO Auto-generated method stub
		for (int index = 1 ; index < visited.length ; index++){
			visited[index] = false;
		}
		ArrayList<Integer> reachable = new ArrayList<Integer>();
		dfs(node);
		for (int index = 1 ; index < visited.length ; index++){
			if(visited[index])
				reachable.add(index);
		}
		return reachable;
	}
	
	/**
	 * function to find mst using prims algo
	 * @param src -> Source node
	 */
	public void primsAlgo(Integer src){
		for (int index = 0; index < edgeList.length; index++){ 
            dist[index] = Integer.MAX_VALUE; 
		}
		for (int index = 1 ; index < visited.length ; index++){
			visited[index] = false;
		}
		pQueue.enQueue(new PriorityNode(src, 0));  
        dist[src] = 0; 
        
        while (!pQueue.isEmpty()) { 
            PriorityNode tempNode = pQueue.deQueue();
            int currNode = (int) tempNode.getData(); 
            int currDist = Math.abs(tempNode.getPriority());
            visited[currNode] = true;
            for(GraphNode node : edgeList[currNode].getArrayOfGraphNodes() ){
            	if((!visited[node.edge]) &&  dist[node.edge] > node.weight){
            		dist[node.edge] = node.weight;
            		pQueue.enQueue(new PriorityNode(node.edge, - (dist[node.edge])));
            		prims[node.edge] = currNode;
            	}
            }
        }
	}
	
	@Override
	public void mst(Integer src) {
		// TODO Auto-generated method stub
		primsAlgo(src);
		for (int index = 1 ; index < visited.length ; index++){
			if(prims[index] != 0){
				System.out.println(prims[index] + "->" + index);;
			}
		}
	}

	/**
	 * function to find shortest path using dijkastra 
	 * @param src -> source node
	 */
	public void dijkstra(int src) {  
		for (int index = 0; index < edgeList.length; index++){ 
            dist[index] = Integer.MAX_VALUE; 
		}
		for (int index = 0; index < edgeList.length; index++){ 
            path[index] = new LinkedList(); 
		}
		pQueue.enQueue(new PriorityNode(src, 0));  
        dist[src] = 0; 
        while (!pQueue.isEmpty()) { 
            PriorityNode tempNode = pQueue.deQueue();
            int currNode = (int) tempNode.getData(); 
            int currDist = Math.abs(tempNode.getPriority());
            for(GraphNode node : edgeList[currNode].getArrayOfGraphNodes() ){
            	if (currDist + node.weight < dist[node.edge]){
            		dist[node.edge] = currDist + node.weight;
            		pQueue.enQueue(new PriorityNode(node.edge, - (dist[node.edge])));
            		path[node.edge].insert(currNode);;
            	}
            }
        } 
    } 
	
	@Override
	public void shortestPath(Integer src, Integer dest) {
		dijkstra(src);
		System.out.print(src+"->");
		path[dest].printList();
		System.out.print(dest+"       " +"   Distance: " +dist[dest]);
	}

}