package Solutions;

public class MaxWater {
	
	static int findMaxWater(int[] heights) {
		int left = 0, right = heights.length - 1;
		int max = 0;
		
		while (left < right) {
			max = Math.max(max, (left-right) *Math.min(heights[left], heights[right]));
			
			if (left > right)
					left++;
			else if (left <right)
				right--;
			else {
				left++;
				right--;
			}
			
		}
		return max;
	}

}
