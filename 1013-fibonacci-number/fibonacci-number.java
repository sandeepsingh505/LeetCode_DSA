class Solution {
// approach  : 1 memoization
    // public int helper(int n ,int[]arr){
    //     if(n==0 || n==1) return 1;
    //     if(arr[n]!= 0){
    //         return arr[n];
    //     }
    //    int ans = helper(n-1,arr) + helper(n-2,arr);
    //    return ans;
    // }
    public int fib(int n) {
        // Tabulation : 
                if(n<=1) return n;

        int[] dp = new int[3];
        
        dp[0] = 0;dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
         return dp[2];
        
    }
}