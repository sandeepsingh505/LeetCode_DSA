class Solution {
    public int solve(int i ,int[]arr,int[]dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = arr[i] + solve(i+2,arr,dp);
        int notpick = solve(i+1,arr,dp);
        return dp[i] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
       Arrays.fill(dp,-1);
        return solve(0,nums,dp);
        
    }
}