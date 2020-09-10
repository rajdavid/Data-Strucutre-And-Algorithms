package DynamicProgramming;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 * 
 * 
 * */
public class LongestpalindromicSubstring {
	public String longestPalindrome(String s) {
	       
        if(s == null || s.equals("")){
            return s;
        }
       
        int n = s.length();
        int[][] dp = new int[n][n];
       
        int maxLength = 1;
       
        // Length of sub str as 1 - fill diagonal
        for(int i=0; i<n ;i++){
            dp[i][i] = 1;
        }
       
        int startIndex = 0;
       
        // Length of sub str as 2 - fill right diagonal
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                startIndex = i;
                maxLength = 2;
            }
        }
       
        // Consider s = "abacab" , length or n = 6
       
    // Iterating for length of sub str that we are looking for, starting from 3
        for(int k=3; k<=n; k++){
    // if n = 6 , k =3 , i will loop till index 3 ( leaving 4 and 5 as one length and two length are handled before)
            for(int i=0; i<= n-k; i++){
                int j = i+k-1; // if i = 3, k = 3, j = 5 ( last index of string )
                if(s.charAt(i) == s.charAt(j)){
                    if(dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        if(k > maxLength){
                            startIndex = i;
                            maxLength = k;
                        }  
                    }
                }
            }
        }
       
        String res = s.substring(startIndex, startIndex+maxLength);
        return res;
    }
}
