package Asssignment5_DSA;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BSTDictonary {
	private TreeNode root;
	
	public TreeNode getRoot(){
		return root;
	}
	
	/**
	 * helper method which sets the root to the root return by inserRec function which inserts the node in BST 
	 * @param key
	 * @param data
	 */
	void insert(int key ,int data) { 
         root = insertRec(root, key , data); 
    }
 
	/**
	 * method to insert node in BST recursively
	 * @param root
	 * @param key
	 * @param data
	 * @return
	 */
    TreeNode insertRec(TreeNode root, int key ,int data){
        if (root == null) 
        {
            root = new TreeNode(key,data);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key, data);
        else if (key > root.key)
            root.right = insertRec(root.right, key, data);
        return root;
    }
    
    /**
     * helper method to delete a node 
     * @param key
     */
    public void deleteKey(int key) { 
    	root = deleteNode(root, key); 
    }
    
    /**
     * method to find in-order successor
     * @param root
     * @return
     */
    public TreeNode Successor(TreeNode root){
        root=root.right;
        while(root.left!=null)
            root=root.left;
        return root;
    }
    
    /**
     * method to find in-order Predecessor
     * @param root
     * @return
     */
    public TreeNode Predecessor(TreeNode root){
        root=root.left;
        while(root.right!=null)
            root=root.right;
        return root;
    }
    
    /**
     * method to delete a node recursively
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(key>root.key)
            root.right=deleteNode(root.right,key);
        else if(key<root.key)
            root.left=deleteNode(root.left,key);
        else{
            if(root.left==null && root.right==null)
                root=null;
            else if(root.right!=null){
                TreeNode temp =Successor(root);
                root.key =temp.key;
                root.data = temp.data;
                root.right=deleteNode(root.right,root.key);
            }
            else{
                TreeNode temp =Predecessor(root);
                root.key =temp.key;
                root.data = temp.data;
                root.left=deleteNode(root.left,root.key);
            }
        }
        return root;
    }
	
    /**
     * method to find value at a given key
     * @param current
     * @param key
     * @return
     */
	public int find(TreeNode current, int key) {
	    if (current == null) {
	        return -1;
	    } 
	    if (key == current.key) {
	        return current.data;
	    } 
	    return key < current.key
	      ? find(current.left, key)
	      : find(current.right, key);
	}
	  
	/**
	 * method to perform in-order traversal of BST
	 * @param node
	 */
	public void inorderTraversal(TreeNode node) {  
		   
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
         }  
        else {  
        	  
            if(node.left!= null)  
                inorderTraversal(node.left);  
            System.out.println("key : " + node.key + "     data : " + node.data); 
            if(node.right!= null)  
                inorderTraversal(node.right);  
        }  
    }  
	
	/**
	 * method to print values in a given key range
	 * @param node
	 * @param key1
	 * @param key2
	 */
	void PrintInRange(TreeNode node, int key1, int key2) {
        
        if (node == null) {
            return;
        }
 
        if (key1 < node.key) {
            PrintInRange(node.left, key1, key2);
        }
 
        if (key1 <= node.key && key2 >= node.key) {
            System.out.print(node.data + " ");
        }
 
        if (key2 > node.key) {
            PrintInRange(node.right, key1, key2);
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
		BSTDictonary dict = new BSTDictonary();
		
		//inserting data using json file
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject =  (JSONObject)parser.parse(new FileReader(".\\data\\data.json"));
			JSONArray nodes = (JSONArray) jsonObject.get("nodes");
			for(int i = 0 ; i < nodes.size(); i++) {
				JSONArray node = (JSONArray) nodes.get(i);
				Iterator<Long> iterator = node.iterator();
				int key = iterator.next().intValue();
				int value = iterator.next().intValue();
				dict.insert(key , value ); 
		    }
		}
		
		catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		catch (IOException e) {
            e.printStackTrace();
        } 
		catch (ParseException e) {
            e.printStackTrace();
        }
		System.out.println("find  : " + dict.find(dict.getRoot(), 45));
		
		System.out.print("Inorder : ");
		dict.inorderTraversal(dict.getRoot());
		
		System.out.println();
		dict.deleteKey(50);
		System.out.print("Deleted Inorder : ");
		dict.inorderTraversal(dict.getRoot());
		
		System.out.println();
		dict.PrintInRange(dict.getRoot(), 20, 50);
		
	}
}
