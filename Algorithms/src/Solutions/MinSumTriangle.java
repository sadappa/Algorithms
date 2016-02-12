package Solutions;

public class MinSumTriangle {
	
	static int minSum(int[][] tri) {
		int[] result = new int[tri.length];
		int len = tri.length - 1;
		for(int i = 0; i < tri[len].length; i++) {
			result[i] = tri[len][i];
		}
		
		for(int j = len - 1; j >=0; j--) {
			for(int i = 0 ; i < tri[j+1].length - 1; i++) {
				result[i] = tri[j][i] + Math.min(result[i], result[i+1]);
			}
		}
		return result[0];
	}
	
	public static void main(String[] args) {
		int[][] tri = {{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println(minSum(tri));
	}
}
