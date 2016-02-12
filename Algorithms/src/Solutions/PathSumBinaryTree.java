package Solutions;

public class PathSumBinaryTree {

	static boolean PathSumBinaryTree(Node root, int sum) {
		
		if (root == null)
			return false;
		return PathSumBinaryTreeHelper(root, 0, sum);
	}

	private static boolean PathSumBinaryTreeHelper(Node root, int sum, int target) {
		
		if (root == null)
			return false;
		sum += root.val;
		
		if (root.left == null && root.right == null) 
			return sum == target;	
		
		return PathSumBinaryTreeHelper(root.left, sum, target) || 
				PathSumBinaryTreeHelper(root.right, sum, target);
	}
}
