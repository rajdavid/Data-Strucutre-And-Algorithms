package DynamicProgramming;

public class MinimumSumPartition {
	public static void main(String[] args) {

		int[] arr = new int[] {1,6,5,11,23,39};
		int result = calculateMinSumParition(arr);
		System.out.println("Result : " + result);

	}



	private static int calculateMinSumParition(int[] arr) {
		int m = arr.length;
		int sum = 0;
		for(int i=0;i<m;i++) {
			sum+=arr[i];
		}
		System.out.println("Sum is : " + sum);
		int target = sum/2; // floor
		int n=target;
		System.out.println("Target  is : " + target);
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;

		for(int i=1; i<=m ;i++ ) {
			for(int j=0; j<=n; j++) {
				if(arr[i-1]<=j) {
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		int maxSumInSubsetOne = -1;

		for(int j=n; j>=0; j--) {
			if(dp[m][j]) {
				System.out.println("j is : " + j);
				maxSumInSubsetOne = j;
				break;
			}
		}
		System.out.println("maxSumInSubsetOne is : " + maxSumInSubsetOne);
		int maxSumInSubsetTwo = sum - maxSumInSubsetOne;
		System.out.println("maxSumInSubsetTwo is : "+ maxSumInSubsetTwo);	
		return maxSumInSubsetTwo - maxSumInSubsetOne;
	}
}
