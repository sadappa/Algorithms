package Solutions;

public class AirBnBMax {
	
	public static int maxNights(int[] a) {
		
		int dp[] = new int[a.length+1];
		dp[0] = 0;
		dp[1] = a[0];
		
		for(int i = 2; i<= a.length; i++) {
			dp[i] = Math.max(dp[i-2] + a[i-1], dp[i-1]);
		}
		return dp[a.length];
	}

	public static void main(String[] args) {
		int[] input = {1,2,3};
		System.out.println(maxNights(input));
		int [] input2 = {5,1,2,6};
		System.out.println(maxNights(input2));
		int [] input3 = {5, 1, 2, 6, 20, 2};
		System.out.println(maxNights(input3));
	}
}
