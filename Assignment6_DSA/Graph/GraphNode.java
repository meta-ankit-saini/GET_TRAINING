package Asssignment6_DSA;

import java.util.Comparator;

public class GraphNode implements Comparator<GraphNode> {
	int edge , weight;
	GraphNode  next;
	public GraphNode(int edge , int weight){
		this.edge = edge;
		this.weight = weight;
		next = null;
	}
	
	@Override
	public int compare(GraphNode node1, GraphNode node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}
