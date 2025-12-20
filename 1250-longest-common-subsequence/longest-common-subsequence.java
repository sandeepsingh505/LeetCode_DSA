class Solution {
    public int helper(int idx1,int idx2,String a, String b, int dp[][]){
        if(idx1==a.length()||idx2==b.length()) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(a.charAt(idx1)==b.charAt(idx2)) return dp[idx1][idx2]=1 + helper(idx1+1,idx2+1,a,b,dp);
        return dp[idx1][idx2]= Math.max(helper(idx1+1,idx2,a,b,dp),helper(idx1,idx2+1,a,b,dp));
    }
    public int longestCommonSubsequence(String a, String b) {
        int dp[][] = new int[a.length()][b.length()];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(0,0,a,b,dp);
        
    }
}