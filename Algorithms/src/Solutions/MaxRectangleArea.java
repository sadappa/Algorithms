package Solutions;

import java.util.Stack;

public class MaxRectangleArea {

	public static int maxArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h*w);
			}
		}
		
		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h*w);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] a = {2,1,5,6,2,3};
		System.out.println(maxArea(a));
	}

}
