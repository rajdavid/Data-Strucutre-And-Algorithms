/*
iven two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings. 

If there is no common subsequence, return 0.

 
*/


public class LongestCommonSubsequnce {
    public int solve(String A, String B) {
       
        int m = A.length();
        int n = B.length();
        
        int max = Integer.MIN_VALUE;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i<=m ;i++){
            
            for(int j=1; j<=n ;j++){
                
                if( A.charAt(i-1) == B.charAt(j-1) ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}