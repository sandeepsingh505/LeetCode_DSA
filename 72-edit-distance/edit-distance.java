class Solution {
    public int helper(int i , int j ,String a,String b,int[][]dp){
       if (i == a.length()) return b.length() - j;
    if (j == b.length()) return a.length() - i;

        if(dp[i][j]!=-1) return dp[i][j]; 
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]=helper(i+1,j+1,a,b,dp);
        else{
            int del = helper(i+1,j,a,b,dp);
            int ins = helper(i,j+1,a,b,dp);
            int repl = helper(i+1,j+1,a,b,dp);
            return dp[i][j] = 1+ Math.min(del,Math.min(ins,repl));
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(0,0,word1,word2,dp);
        
    }
}