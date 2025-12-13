class Solution {
    public int helper(int n ,int[]arr){
        if(n==0 || n==1) return n;
        if(arr[n]!= -1){
            return arr[n];
        }
       int ans = helper(n-1,arr) + helper(n-2,arr);
       return ans;
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
         Arrays.fill(dp,-1);
         return helper(n,dp);
        
    }
}