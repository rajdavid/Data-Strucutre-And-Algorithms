package DynamicProgramming;

public class LongestIncreasingPathInMatrix {
	
	
	/*iven an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
	 * 
	 * */
	
	public int longestIncreasingPath(int[][] mat) {
	       int m = mat.length;    
	        if(m==0){
	            return 0;
	        }
	        int n  = mat[0].length;
	        int[][] dp = new int[m][n];      
	        int max = 1;
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	             int r =  findLIP(i,j,mat,dp, Integer.MIN_VALUE);
	                if(r>max){
	                    max=r ;
	                }
	            }
	        }
	        return max;
	    }
	       
	        public int findLIP(int i, int j , int[][] mat, int[][]dp, int prev){
	           
	            if(i<0 || j<0 || i>=mat.length || j>= mat[0].length){
	                return 0;
	            }
	           
	            // if numbers are equal , don't count that
	            if(mat[i][j] <= prev ){
	                return 0;
	            }
	           
	            if( dp[i][j] != 0 ){
	                return dp[i][j];
	            }
	           
	            int left = findLIP(i, j-1, mat,dp, mat[i][j] );
	            int right = findLIP(i, j+1, mat,dp, mat[i][j] );
	            int top = findLIP(i-1, j, mat,dp, mat[i][j] );
	            int down = findLIP(i+1, j, mat,dp, mat[i][j] );
	           
	            dp[i][j] = 1 + Math.max(Math.max(left,right), Math.max(top,down));      
	            return dp[i][j];
	           
	        }

}
