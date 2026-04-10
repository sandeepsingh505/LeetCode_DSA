class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
        }
        for(int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int idx1 = -1;
            for(int j = 0; j < n; j++) {
                if(dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    idx1 = j;
                } else if(dp[j] < min2) {
                    min2 = dp[j];
                }
            }
            int[] newDp = new int[n];
            for(int j = 0; j < n; j++) {
                if(j == idx1) {
                newDp[j] = grid[i][j] + min2;
        } else {newDp[j] = grid[i][j] + min1;
                }
            }
            dp = newDp;
        }
        int ans = Integer.MAX_VALUE;
        for(int val : dp) ans = Math.min(ans, val);

         return ans;
    }
   
    
}