class Solution {
 public int path(int i,int j,int[][]grid,int m ,int n,int dp[][]){
    if(i>=m || j>=n) return 0;
    if(i==m-1 && j==n-1) return 1;
    if(dp[i][j]!=-1) return dp[i][j];
    int down = path(i+1,j,grid,m,n,dp);
    int right = path(i,j+1,grid,m,n,dp);
    return dp[i][j] = down + right;
    
 }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int dp[][] = new int[m][n];
        for(int[]row : dp) Arrays.fill(row,-1);
        return path(0,0,grid,m,n,dp);
        
    }
}