class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }
        return solve(word1,word2,m,n,dp);
    }
    public int solve(String a , String b , int i , int j , int[][]dp){
     if(i==0) return j;
     if(j==0) return i;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i-1)== b.charAt(j-1)){
            return dp[i][j] = solve(a,b,i-1,j-1,dp);
        }
        int insert = solve(a,b,i,j-1,dp);
        int delete = solve(a,b,i-1,j,dp);
        int replace = solve(a,b,i-1,j-1,dp);
        return dp[i][j] = 1 + Math.min(insert,Math.min(delete,replace));
    }
}