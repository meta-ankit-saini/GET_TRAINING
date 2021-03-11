package Asssignment5_DSA;

public class BSTDictonary {
	private TreeNode root;
	
	public TreeNode getRoot(){
		return root;
	}
	
	void insert(int key ,int data) 
    { 
         root = insertRec(root, key , data); 
    }
 

    TreeNode insertRec(TreeNode root, int key ,int data)
    {
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
    
    void deleteKey(int key) { 
    	root = deleteRec(root, key); 
    }
    
    /* A recursive function to 
      delete an existing key in BST
     */
    TreeNode deleteRec(TreeNode root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's 
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
 
        return root;
    }
    
    int minValue(TreeNode root)
    {
        int minv = root.key;
        while (root.left != null) 
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	
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
	
//	public TreeNode minNode(TreeNode root) {  
//        if (root.left != null)  
//            return minNode(root.left);  
//        else  
//            return root;  
//    }  
//	
//	public TreeNode deleteNode(TreeNode node, int key) {  
//        if(node == null){  
//            return null;  
//         }  
//        else {  
//            if(key < node.key)  
//                node.left = deleteNode(node.left, key);  
// 
//            else if(key > node.key)  
//                node.right = deleteNode(node.right, key);  
//
//            else {  
//                if(node.left == null && node.right == null)  
//                    node = null;  
//
//                else if(node.left == null) {  
//                    node = node.right;  
//                }  
// 
//                else if(node.right == null) {  
//                    node = node.left;  
//                }  
//
//                else {    
//                    TreeNode temp = minNode(node.right);  
//                    node.data = temp.data;    
//                    node.right = deleteNode(node.right, temp.data);  
//                }  
//            }  
//            return node;  
//        }  
//    }  
	
	public  TreeNode minimumElement(TreeNode root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}
		 
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.data > key) {
			root.left = deleteNode(root.left, key);
		} 
		else if (root.data < key) {
			root.right = deleteNode(root.right, key);
		 
		} 
		else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				TreeNode temp = root;
				// Finding minimum element from right
				TreeNode minNodeForRight = minimumElement(temp.right);
				// Replacing current node with minimum node from right subtree
				root.data = minNodeForRight.data;
				// Deleting minimum node from right now
				root.right = deleteNode(root.right, minNodeForRight.data);
		 
			}
			// if nodeToBeDeleted has only left child
			else if (root.left != null) {
				root = root.left;
			}
			// if nodeToBeDeleted has only right child
			else if (root.right != null) {
				root = root.right;
			}
			// if nodeToBeDeleted do not have child (Leaf node)
			else
				root = null;
		 }
		 return root;
	}
	
	public void inorderTraversal(TreeNode node) {  
		   
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
         }  
        else {  
        	  
            if(node.left!= null)  
                inorderTraversal(node.left);  
            System.out.print(node.data + " "); 
            if(node.right!= null)  
                inorderTraversal(node.right);  
        }  
    }  
	
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
	
	public static void main(String[] args){
		BSTDictonary dict = new BSTDictonary();
		
		dict.insert(50, 101);
		dict.insert(10, 102);
		dict.insert(20, 103);
		dict.insert(8, 104);
		dict.insert(40, 105);
		dict.insert(45, 106);
		dict.insert(60, 107);
		dict.insert(55, 108);
		dict.insert(65, 109);
		dict.insert(58, 110);
		dict.insert(70, 111);
		dict.insert(68, 112);
		
		System.out.println("find  : " + dict.find(dict.getRoot(), 45));
		
		System.out.print("Inorder : ");
		dict.inorderTraversal(dict.getRoot());
		
		System.out.println();
		dict.deleteKey(70);
		System.out.print("Deleted Inorder : ");
		dict.inorderTraversal(dict.getRoot());
		
		System.out.println();
		dict.PrintInRange(dict.getRoot(), 20, 50);
		
	}
}
