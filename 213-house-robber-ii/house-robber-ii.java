class Solution {
    public int helper(int start,int end, int[]nums,int[]dp){
        if(start>end) return 0;
        if(dp[start]!=-1) return dp[start];
        int take = nums[start] + helper(start+2,end,nums,dp);
        int skip = helper(start+1,end,nums,dp);
        return dp[start]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[]dp1 = new int[n];
        int[]dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
       int case1 = helper(0,n-2,nums,dp1);
       int case2 = helper(1,n-1,nums,dp2);
       return Math.max(case1,case2);
        
    }
}