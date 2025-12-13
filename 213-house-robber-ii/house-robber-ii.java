class Solution {
    public int helper(int[]nums,int idx,int lastidx,int []dp){
        int n = nums.length;
        if(idx >lastidx) return 0;
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick = nums[idx] + helper(nums,idx+2,lastidx,dp);
        int notpick = helper(nums,idx+1,lastidx,dp);
        dp[idx] = Math.max(pick,notpick);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int case1 = helper(nums,0,n-2,dp1);
        int case2 = helper(nums,1,n-1,dp2);
        return Math.max(case1,case2);
        
    }
}