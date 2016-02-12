package Solutions;

import java.util.Arrays;
import java.util.List;

public class Boggle {
	
	static String[] dictionary = {"GEEKS","FOR","QUIZ","GO"};
	static List<String> dict = Arrays.asList(dictionary);
	
	static void findWords(char[][] mat) {
		
		int m = mat.length;
		int n = mat[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i< m;i++) {
			for(int j = 0;j < n;j++) {
				visited[i][j] = false;
			}
		}
		
		String word = "";
		
		for (int i = 0; i< m;i++) {
			for(int j = 0;j < n;j++) {
				findWordsHelper(mat, i, j, word, visited, m, n);
			}
		}
		
	}

	private static void findWordsHelper(char[][] mat, int i, int j, String word, boolean[][] visited, int m, int n) {
		
		if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
			return;
		
		word += mat[i][j];
		visited[i][j] = true;
		if(dict.contains(word)) {
			System.out.println(word);
		}
		
		for (int r = i-1; r<=i+1;r++) {
			for(int c = j-1;c <= j+1;c++) {
				findWordsHelper(mat, r, c, word, visited, m, n);
			}
		}
		
		word = word.substring(0, word.length()-1);
		visited[i][j] = false;
		
	}

	public static void main(String[] args)
	{
	    char boggle[][] = {{'G','I','Z'},
	                         {'U','E','K'},
	                         {'Q','S','E'}};
	 
	    findWords(boggle);
	}
}
