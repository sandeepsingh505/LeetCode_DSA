class Solution {
    public int lcs(int i,int j,String a,String b,int[][]dp){
        if(i==a.length()||j==b.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return 1 + lcs(i+1,j+1,a,b,dp);
        return dp[i][j] = Math.max(lcs(i+1,j,a,b,dp),lcs(i,j+1,a,b,dp));
    }
    public int longestCommonSubsequence(String a, String b) {
        int[][]dp = new int[a.length()][b.length()];
        for(int[]row : dp) Arrays.fill(row,-1);
        return lcs(0,0,a,b,dp);
        
    }
}