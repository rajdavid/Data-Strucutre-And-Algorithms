package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequnce {
	
public int lengthOfLIS(int[] a) {
        
        if(a.length==0) return 0;
        int dp[]=new int[a.length+1];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[j]<a[i] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
                if(dp[i]> max)
                    max=dp[i];
            }
        }
        return max;
        
    }
}
