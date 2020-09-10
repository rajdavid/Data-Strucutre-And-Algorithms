package DynamicProgramming;

public class CoinChange {

	//You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

	/*Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
	 * */

	public int change(int amount, int[] coins) {
		//Arrays.sort(coins);
		int m=coins.length;
		int n=amount;
		int [][]dp=new int [m+1][n+1];

		for(int i=1;i<=amount;++i)
			dp[0][i] = 0;
		for(int j=0;j<=m ;j++)
			dp[j][0]=1;
		for(int i =1;i<=m;i++){

			for(int j=1;j<=n;j++){

				if(j>=coins[i-1])
					dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];

			}

		}
		return dp[m][n];


	}

}
