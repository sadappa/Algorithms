package Solutions;

public class SortedToBST {
	public static Node sortedToBST(int[] A) {
		
		if(A.length == 0)
			return null;
		
		return sortedToBST(A, 0, A.length -1);
	}

	private static Node sortedToBST(int[] A, int left, int right) {
		
		if (left > right)
			return null;
		int mid = (left + right)/2;
		Node tree = new Node(A[mid]);
		
		tree.left = sortedToBST(A, left, mid-1);
		tree.right = sortedToBST(A, mid+1, right);
		return tree;
	}
}
