class Solution {
    public int uniquepath(int i,int j,int arr[][],int dp[][]){
        if(i>=arr.length || j>=arr[0].length) return 0;
        if(arr[i][j]==1)return 0;
        if(i==arr.length-1 && j==arr[0].length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = uniquepath(i+1,j,arr,dp);
        int right = uniquepath(i,j+1,arr,dp);
        return dp[i][j] = down + right;

    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int dp[][] = new int[arr.length][arr[0].length];
        for(int[]row : dp) Arrays.fill(row,-1);
        return uniquepath(0,0,arr,dp);
        
    }
}