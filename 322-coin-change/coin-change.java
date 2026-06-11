class Solution {
    public int helper(int i ,int[] coins, int amount,int[][]dp){
        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE-1;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take = Integer.MAX_VALUE;
        if(coins[i]<=amount){
           take = 1 + helper(i,coins,amount-coins[i],dp);
        }
     int   nottake = helper(i+1,coins,amount,dp);
      return   dp[i][amount] = Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][]dp = new int[coins.length][amount+1];
        for(int[]row : dp) Arrays.fill(row,-1);
       int ans = helper(0,coins,amount,dp);
       if(ans==Integer.MAX_VALUE-1) return -1;
       else return ans;
    }
}