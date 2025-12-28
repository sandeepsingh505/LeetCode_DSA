class Solution {
    public int requiredhp(int i,int j,int[][] arr,int[][] dp){
        int m = arr.length;
        int n = arr[0].length;
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return Math.max(1,1-arr[i][j]);
        if(dp[i][j]!=-1) return dp[i][j];
        int right = requiredhp(i,j+1,arr,dp);
        int down = requiredhp(i+1,j,arr,dp);
        int need = Math.min(right,down)-arr[i][j];    // calculating the health required for future cell 
        return dp[i][j] = Math.max(1,need);
    }
    public int calculateMinimumHP(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][]dp = new int[m][n];
        for(int[]row : dp) Arrays.fill(row,-1);
        return requiredhp(0,0,arr,dp);
        
    }
}