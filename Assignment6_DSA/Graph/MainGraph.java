package Asssignment6_DSA;

import java.util.Scanner;

public class MainGraph {
	
	public static GraphEdgeList[] createGraphUsingEdgeList(int noOfNode , int noOfEdge){
		Scanner scan = new Scanner(System.in);
		GraphEdgeList[] edgeList = new  GraphEdgeList[noOfNode + 1];
		for(int index = 0; index < noOfNode + 1 ; index++){
			edgeList[index] = new GraphEdgeList();
		}
		System.out.printf("enter %d node : \n " , noOfEdge); 
		for(int index = 0; index < noOfEdge ; index++){
			System.out.println("enter node 1 : ");
			int node1 = scan.nextInt();
			System.out.println("enter node 2 : ");
			int node2 = scan.nextInt();
			System.out.println("enter weight of edge : ");
			int weight = scan.nextInt();
			edgeList[node1].insert(node2, weight);
			edgeList[node2].insert(node1, weight);
		}
		return edgeList;
	}
	
	public static void printEdgeList(GraphEdgeList[] edgeList){
		for (int index = 1; index  <edgeList.length ; index++){
			System.out.print(index+"   ");
			for(int edge : edgeList[index].getEdgeArrayOfGraph()){
				System.out.print(edge+"   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no of nodes : ");
		int noOfNode = scan.nextInt();
		System.out.println("Enter no of Edges : ");
		int noOfEdge = scan.nextInt();
		GraphEdgeList[] edgeList = createGraphUsingEdgeList(noOfNode, noOfEdge);
		System.out.println(edgeList.length);
		printEdgeList(edgeList);
		Graph graph = new Graph(edgeList);
		System.out.println("Is connected : "+graph.isConnected());
		System.out.println("Reachable : "+graph.reachable(1));
		System.out.println("Shortest Path ");
		graph.shortestPath(1, 4);
		System.out.println();
		System.out.println("MST :  ");
		graph.mst(1);
	}
}
