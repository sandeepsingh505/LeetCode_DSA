class Solution {
     public int helper(int i,int j,String s1,String s2,int[][]dp){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]= 1+ helper(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(helper(i,j-1,s1,s2,dp),helper(i-1,j,s1,s2,dp));
    }
    public int minDistance(String s1, String s2) {
         int n = s1.length() , m = s2.length();
        int[][]dp= new int[n+1][m+1];
        for(int[]row : dp) Arrays.fill(row,-1);
        int ans = helper(n,m,s1,s2,dp);
        return n+m-2*ans;
    }
}