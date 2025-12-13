class Solution {
    public int helper(int row,int col,int m ,int n,int [][]dp){
        if(row >= m || col>=n)return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int right = helper(row,col+1,m,n,dp);
        int down = helper(row+1,col,m,n,dp);
        dp[row][col] = right + down;
        return dp[row][col];
    }
    public int uniquePaths(int m, int n) {
     int [][] dp = new int[m][n];
      for(int val[]:dp){
        Arrays.fill(val,-1);
      }
     return helper(0,0,m,n,dp);
        
    }
}