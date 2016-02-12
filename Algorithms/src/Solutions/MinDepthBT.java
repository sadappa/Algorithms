package Solutions;

public class MinDepthBT {
	
	public static int minDepth(Node root) {
		if(root == null)
			return 0;
		
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		
		return Math.min(left, right) + 1;
	}

}
