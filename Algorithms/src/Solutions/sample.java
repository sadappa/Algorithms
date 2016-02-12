package Solutions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class sample {
                  
	public static int countWords(String sentence){
	    int startWord = 0;
	    int endWord = 0;
	    int numOfWords = 0;
	    
	    if(sentence == null) return -1;
	    
	    while(endWord != sentence.length()-1 && sentence.length() != 0){
	      if (sentence.charAt(endWord) == ' '){
	        if(endWord > startWord){
	           
	             numOfWords++;
	           
	           endWord++;
	           startWord = endWord;
	           
	        } else if (endWord == startWord) {
	           endWord++;
	           startWord++;
	        }
	      } else {
	        endWord++;
	      }
	      
	    }
	    
	    if(sentence.charAt(endWord-1) != ' '){
	       numOfWords++;
	           
	    }
	   return numOfWords;   
	}
	
	static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		boolean[] markedT = new boolean[256];
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == null) {
				if (markedT[t.charAt(i)])
					return false;
				else {
					markedT[t.charAt(i)] = true;
					map.put(s.charAt(i), t.charAt(i));
				}
			} else {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	static List<List<Integer>> pascal(int n) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Integer> level = new ArrayList<>();
			for(int j = 0; j<= i ; j++) {
				
				if (i == 0 || j == 0 || i==j) {
					level.add(1);
				} else {
					level.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
				}
				
			}
			result.add(level);
		}
		
		return result;
		
	}
	
	static List<List<Integer>> printLevelOrder(Node root) {
		Queue<Node> currlevel = new LinkedList<>();
		int numNodes = 0;
		List<List<Integer>> result = new ArrayList<>();
		currlevel.add(root);
		numNodes++;
		List<Integer> level = new ArrayList<>();
		while (!currlevel.isEmpty()) {
			Node curr = currlevel.remove();
			numNodes--;
			
			if (curr != null) {
				level.add(curr.val);
				currlevel.add(curr.left);
				currlevel.add(curr.right);
			}
						
			if (numNodes == 0) {
				result.add(new ArrayList<>(level));
				level.clear();
				numNodes = currlevel.size();
			}
		}
		return result;
	}
	static void twoSum(int[] A, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) {
				map.put(x - A[i], A[i]);
			} else {
				result[0] = A[i];
				result[1] = map.get(A[i]);
				break;
			}
		}
	}
	
	static void serialize(Node root, StringBuilder sb) {
		if (root == null) {
			sb.append("null ");
		} else {
			sb.append(root.val).append(" ");
			serialize(root.left,sb);
			serialize(root.right,sb);
		}
	}
	
	static Node deserialize(StringTokenizer s) {
		String token;
		Node root = null;
		if (!s.hasMoreTokens() || (token = s.nextToken()).equals("null")) {
			return root;
		} else {
			root = new Node(Integer.parseInt(token));
			root.left = deserialize(s);
			root.right = deserialize(s);
		}
		return root;
	}

	static void printPreorder(Node root) {
		if (root == null)
			return;
		else {
			System.out.println(root.val+" ");
			printPreorder(root.left);
			printPreorder(root.right);
		}	
	}
	
	static void printInorder(Node root) {
		if (root == null)
			return;
		else {
			printPreorder(root.left);
			System.out.println(root.val+" ");
			printPreorder(root.right);
		}	
	}
	static int minDistance(String[] words, String word1, String word2) {
		int minDist = Integer.MAX_VALUE, index1 = -1, index2 = -1, temp;
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				index1 = i;
				if (index2 >= 0) {
					temp = Math.abs(index2 - index1);
					minDist = Math.max(minDist, temp);
				}
			}
			else if (words[i].equals(word2)) {
				index2 = i;
				if (index1 >= 0) {
					temp = Math.abs(index1 - index2);
					minDist = Math.max(minDist, temp);
				}
			}
		}
		
		return minDist;
	}
	
	static Stack<Integer> sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	static Node preorderToBST(StringTokenizer st, int min, int max) {
		if (!st.hasMoreTokens())
			return null;
		else {
			Node root = null;
			int val = Integer.parseInt(st.nextToken());
			if (val > min && val < max) {
				root = new Node(val);
				root.left = preorderToBST(st, min, val);
				root.right = preorderToBST(st, val, max);
			}
			return root;
		}	
	}
	public static void main(String[] args) {
//		System.out.println(sample.countWords(" this  "));
		

//	    List<List<Integer>> result = pascal(5);
//	    for (List<Integer> re : result) {
//	      for (Integer aRe : re) {
//	        System.out.print(aRe + " ");
//	      }
//	      System.out.println();
//	    }
		
//		System.out.print(isIsomorphic("aab","xyz"));
//		System.out.print(isIsomorphic("abc","xyz"));
		
//		 	_30_ 
//		   /    \    
//		  10    20
//		 /     /  \ 
//		50    45  35
		Node root = new Node(30);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.left = new Node(50);
		root.right.left = new Node(45);
		root.right.right = new Node(35);
		
		StringBuilder sb = new StringBuilder();
//		serialize(root, sb);
//		System.out.print(sb.toString());
//		System.out.println("\n");
		
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
//		Node root2 = deserialize(st);
//		printPreorder(root2);
//		System.out.println("\n");
		
		st = new StringTokenizer("30 20 10 40 35 50"," ");
		Node bst = preorderToBST(st, Integer.MIN_VALUE, Integer.MAX_VALUE);
		printInorder(bst);
	}
}


