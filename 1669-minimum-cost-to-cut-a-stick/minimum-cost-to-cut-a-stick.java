class Solution {
    public int minCost(int n, int[] cuts) {
        int arr[] = new int [cuts.length+2];
        int m = arr.length;
        arr[0] = 0;
        for(int i = 0;i<cuts.length;i++){
            arr[i] = cuts[i];
        }
        arr[m-1] = n;
        int dp[][] = new int[m-1][m-1];
        for(int row[]:dp) Arrays.fill(row,-1);
        Arrays.sort(arr);
        return helper(1,m-2,arr,dp);
        
    }
    public int helper(int i , int j , int[]arr,int[][]dp){
        int m = arr.length;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
           int total = helper(i,k-1,arr,dp) + helper(k+1,j,arr,dp) + arr[j+1]-arr[i-1];
            min = Math.min(min,total);
        }
        return dp[i][j]= min;
    }
}