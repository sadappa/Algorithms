package Solutions;

public class InorderSuccessor {
	
	public static Node InorderSuccessor(Node root) {
		
		Node curr = root;
		
		if(curr.right != null) {
			Node node = curr.right;
			while (node.left != null)
				node = node.left;
			return node;
		} else {
			while (curr.parent != null && curr == curr.parent.right)
				curr = curr.parent;
			return curr.parent;
		}
	}

}
