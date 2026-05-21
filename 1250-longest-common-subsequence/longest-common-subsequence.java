class Solution {
    public int helper(int m,int n,String s1,String s2,int[][]dp){
        if(m==0||n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = 1 + helper(m-1,n-1,s1,s2,dp);
        }
           return dp[m][n] = Math.max(helper(m,n-1,s1,s2,dp),helper(m-1,n,s1,s2,dp));
    
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[]row : dp) Arrays.fill(row,-1);
        return helper(text1.length(),text2.length(),text1,text2,dp);
    }
}