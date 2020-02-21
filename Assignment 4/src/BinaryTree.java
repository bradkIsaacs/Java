public class BinaryTree {
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	public static TreeNode insert(TreeNode root, TreeNode nodeToBeInserted) {
		if (root == null) {
			root = nodeToBeInserted;
			return root;
		}
		if (root.data > nodeToBeInserted.data) {
			if (root.left == null)
				root.left = nodeToBeInserted;
			else
				insert(root.left, nodeToBeInserted);
		} else if (root.data < nodeToBeInserted.data)
			if (root.right == null)
				root.right = nodeToBeInserted;
			else
				insert(root.right, nodeToBeInserted);
		return root;
	}

	public static TreeNode createBinarySearchTree() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		insert(null, rootNode);
		insert(rootNode, node2);
		insert(rootNode, node3);
		insert(rootNode, node4);
		insert(rootNode, node5);
		insert(rootNode, node6);
		insert(rootNode, node7);
		return rootNode;
	}

	public static void main(String[] args){
		
	}
	
	//Method 1
	public TreeNode mirror(TreeNode root, TreeNode nodeToBeInserted){
		if (root == null) {
			root = nodeToBeInserted;
			return root;
		}
		if (root.data > nodeToBeInserted.data) {
			if (root.right == null)
				root.right = nodeToBeInserted;
			else
				mirror(root.right, nodeToBeInserted);
		} else if (root.data < nodeToBeInserted.data)
			if (root.left == null)
				root.left = nodeToBeInserted;
			else
				mirror(root.left, nodeToBeInserted);
		return root;
	}
	//b) Running time is O(log(n)) 
	
	//Method 2
	public void ChildSwap(TreeNode t){
		if (t.left != null && t.right!=null){
			TreeNode temp = t.left;
			ChildSwap(t.left);
			ChildSwap(t.right);
			t.left = t.right;
			t.right = temp;
		}
	}
	
	//Method 3
	

}