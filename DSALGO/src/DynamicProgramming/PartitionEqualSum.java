package DynamicProgramming;

public class PartitionEqualSum {
	
	public boolean canPartition(int[] nums) {
        int m  = nums.length;
        int sum = 0;
        for(int i=0; i<m; i++){
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
       
        int target = sum/2;
        int n = target;
   
        boolean[][] dp = new boolean[m+1][n+1];
        
        // handle first col
        for(int i=0;i<=m;i++)
        {
            dp[i][0]=true;
         }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                 if(nums[i-1] <= j){  
                    dp[i][j] =  ( dp[i-1][j]  || dp[i-1][j-nums[i-1]] ) ;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

}
