class Solution {
    public int solve(int curr, int prev,int[]nums,int[][]dp){
        if(curr>=nums.length) return 0;
        if(dp[curr][prev+1]!=-1) return dp[curr][prev+1];
        int take = 0;
        if(prev==-1 || nums[prev]< nums[curr]){
            take = 1 + solve(curr+1,curr,nums,dp);
        }
        int nottake = solve(curr+1,prev,nums,dp);
        return dp[curr][prev+1] = Math.max(take,nottake);

    }
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length+1];
        for(int[]row : dp) Arrays.fill(row,-1);
        return solve(0,-1,nums,dp);
    }
}