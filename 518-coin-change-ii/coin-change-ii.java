class Solution {
      public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length+1][amount+1];
              for(int i = 0;i<dp.length;i++){
        dp[i][0] = 1;
      }
        int n = dp.length , m = dp[0].length;
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(j-coins[i-1]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]  = dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}