class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp = new int[coins.length+1][amount+1];
        for(int[]row : dp) Arrays.fill(row,Integer.MAX_VALUE-1);
      for(int i = 0;i<dp.length;i++){
        dp[i][0] = 0;
      }
        int n = dp.length , m = dp[0].length;
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(j-coins[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]  = Math.min(1 + dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }
        if(dp[n-1][m-1]==Integer.MAX_VALUE-1) return -1;
        return dp[n-1][m-1];
    }
}