class Solution {
    public int  lis(int i,int prev ,int[]arr,int[][]dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int skip =  lis(i+1,prev,arr,dp);
        int take = 0;
        if(prev == -1 || arr[i]>arr[prev]){
            take = 1 + lis(i+1,i,arr,dp);
        }
        return dp[i][prev+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][]dp = new int [n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return lis(0,-1,nums,dp);
    }
}