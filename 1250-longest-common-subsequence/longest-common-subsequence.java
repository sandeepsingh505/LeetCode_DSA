class Solution {
    public int solve(String s1, String s2,int m,int n,int[][]dp){
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return dp[m][n] = 1 + solve(s1,s2,m-1,n-1,dp);
        }
        return dp[m][n] = Math.max(solve(s1,s2,m-1,n,dp),solve(s1,s2,m,n-1,dp));
    }
    public int longestCommonSubsequence(String s1, String s2) {
         int[][]dp = new int[s1.length()+1][s2.length()+1];
         for(int[]row : dp) Arrays.fill(row,-1);
         return solve(s1,s2,s1.length(),s2.length(),dp);

        
    }
}