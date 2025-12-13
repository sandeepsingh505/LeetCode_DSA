class Solution {
    public int helper(int[] nums, int idx,int[]dp){
        int n = nums.length;
        if(idx>= n  ) return 0 ;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick = nums[idx] +  helper(nums,idx+2,dp);
        int notpick = helper(nums,idx+1,dp);
        dp[idx] = Math.max(pick,notpick);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp [] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
        
    }
}