package Asssignment6_DSA;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph implements GraphInterface{
	private GraphEdgeList[] edgeList;
	private boolean[] visited;
	private int[] dist;
	private PriorityQueue pQueue;
	private int[][]  path;
	private int[] prims;
	
	public Graph(GraphEdgeList[] edgeList ){
		this.edgeList = edgeList;
		visited = new boolean[edgeList.length];
		dist = new int[edgeList.length];
		prims = new int[edgeList.length];
		pQueue = new PriorityQueue();
		path = new int[edgeList.length][edgeList.length];
//		System.out.println(visited.length);
	}
	
	public void dfs(int node){
		visited[node] = true;
//		System.out.println(node);
		for (int child : edgeList[node].getEdgeArrayOfGraph())
			if(!visited[child])
				dfs(child);
	}
	
	public int connectedCompenents() {
		// TODO Auto-generated method stub
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
	
	
	
	@Override
	public int[] mst(Integer src) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edgeList.length; i++){ 
            dist[i] = Integer.MAX_VALUE; 
		}
		for (int index = 1 ; index < visited.length ; index++){
			visited[index] = false;
		}
		pQueue.enQueue(new PriorityNode(src, 0));  
        dist[src] = 0; 
        
        while (!pQueue.isEmpty()) { 
        	pQueue.printQueue();
            PriorityNode tempNode = pQueue.deQueue();
            int currNode = (int) tempNode.getData(); 
            int currDist = Math.abs(tempNode.getPriority());
            visited[currNode] = true;
//            System.out.print(currNode);
            for(GraphNode node : edgeList[currNode].getArrayOfGraphNodes() ){
            	if((!visited[node.edge]) &&  dist[node.edge] > node.weight){
            		dist[node.edge] = node.weight;
            		pQueue.enQueue(new PriorityNode(node.edge, - (dist[node.edge])));
            		prims[node.edge] = currNode;
            	}
            }
        }
		return prims;
	}

	
	public void dijkstra(int src) {  
		for (int i = 0; i < edgeList.length; i++){ 
            dist[i] = Integer.MAX_VALUE; 
		}
        pQueue.enQueue(new PriorityNode(src, 0));  
        dist[src] = 0; 
        while (!pQueue.isEmpty()) { 
            PriorityNode tempNode = pQueue.deQueue();
            int currNode = (int) tempNode.getData(); 
            int currDist = Math.abs(tempNode.getPriority());
//            path[currNode][currNode] = 1;
//            System.out.println("currNode : " + currNode);
            for(GraphNode node : edgeList[currNode].getArrayOfGraphNodes() ){
            	if (currDist + node.weight < dist[node.edge]){
            		dist[node.edge] = currDist + node.weight;
            		pQueue.enQueue(new PriorityNode(node.edge, - (dist[node.edge])));
//            		System.out.println("node : " + node.edge);
            		path[node.edge][currNode] = 1;
            	}
            }
        } 
    } 
	
	@Override
	public int[] shortestPath(Integer src, Integer destination) {
		dijkstra(src);
		return  path[destination];
	}

}
