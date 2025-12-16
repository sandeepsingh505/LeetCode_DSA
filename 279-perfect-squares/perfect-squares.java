class Solution {
    public boolean isperfect(int n){
       int sq = (int)Math.sqrt(n);
       return (sq * sq == n);
        
    }
    // Approach : 1 Recursion + Memoization

    // public int helper(int n ,int[]dp){
    //     if(isperfect(n)) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     int minsum = Integer.MAX_VALUE;
    //     for(int i =1;i*i<=n;i++){
    //         int count = helper(i*i,dp) + helper(n-i*i,dp);
    //         minsum = Math.min(minsum,count);
    //     }
    //     return dp[n] = minsum;
    // }
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i= 1;i<=n;i++){
             dp[i] =  Integer.MAX_VALUE;
             for(int j = 1;j*j<=i;j++){
                 dp[i] = Math.min(dp[i],1  + dp[i-j*j]);
                
            }
           

        }
         return dp[n];
        
    }
}