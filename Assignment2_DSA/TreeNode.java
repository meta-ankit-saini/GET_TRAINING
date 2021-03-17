package Asssignment5_DSA;
/**
 * Class Representing Structure Of Tree Node
 * @author ankit.saini_metacube
 *
 */
public class TreeNode {
	int key , data;
	TreeNode left , right;
	
	public TreeNode(int key , int data){
		this.key = key;
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
