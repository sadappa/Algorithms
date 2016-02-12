package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutations {
	
	public static List<List<String>> palindromeParts(String input) {
		
		List<List<String>> result = new ArrayList<>();
		List<String> partial = new ArrayList<>();
		
		palindromePartsHelper(input, 0, partial, result);
		return result;
		
		
	}

	private static void palindromePartsHelper(String input, int offset, List<String> partial, List<List<String>> result) {
		
		if(offset == input.length()-1) {
			result.add(new ArrayList<String>(partial));
			return;
		}
		for(int i = offset+1 ; i < input.length(); i++) {
			String prefix = input.substring(offset,i);
			
			if(isPalindrome(prefix)) {
				partial.add(prefix);
				palindromePartsHelper(input, i, partial, result);
				partial.remove(partial.size()-1);
			}
			
		}
	}

	private static boolean isPalindrome(String prefix) {
		int left = 0, right = prefix.length()-1;
		
		while(left < right) {
			if(prefix.charAt(left) != prefix.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
