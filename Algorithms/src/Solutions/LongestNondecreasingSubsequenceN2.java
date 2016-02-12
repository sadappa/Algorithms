package Solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNondecreasingSubsequenceN2 {

	public static int longestNondecreasingSubsequenceLength(List<Integer> A) {
		// maxLength[i] holds the length of the longest nondecreasing
		// subsequence of
		// A[0 : i].
		Integer[] maxLength = new Integer[A.size()];
		Arrays.fill(maxLength, 1);
		for (int i = 1; i < A.size(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (A.get(i) >= A.get(j)) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}
		}
		return Collections.max(Arrays.asList(maxLength));
	}
	
	public static void main(String[] args) {
		System.out.println(longestNondecreasingSubsequenceLength(Arrays.asList(0,8,4,12,2,10,6,14,1,9)));
	}

}
