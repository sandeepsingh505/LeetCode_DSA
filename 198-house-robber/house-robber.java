class Solution {
    // approach 1 : memoization
    // public int helper(int[] nums, int idx,int[]dp){
    //     int n = nums.length;
    //     if(idx>= n  ) return 0 ;
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int pick = nums[idx] +  helper(nums,idx+2,dp);
    //     int notpick = helper(nums,idx+1,dp);
    //     dp[idx] = Math.max(pick,notpick);
    //     return dp[idx];
    // }
    public int rob(int[] nums) {
     // Approach 2 : Tabulation
        int n = nums.length;
        int dp [] = new int[n+1];
        if(n==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(nums[i]+ dp[i-2],dp[i-1]);
        }
        return dp[n-1];
        
        
    }
}