class Solution {
    public int helper(int m,int n ,int[]arr1,int[]arr2,int[][]dp){
        if(m==0|| n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(arr1[m-1]==arr2[n-1]){
            return dp[m][n] = 1 + helper(m-1,n-1,arr1,arr2,dp);
        }
        return dp[m][n] = Math.max(helper(m-1,n,arr1,arr2,dp),helper(m,n-1,arr1,arr2,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][]dp = new int[nums1.length+1][nums2.length+1];
        for(int[]row:dp) Arrays.fill(row,-1);
        return helper(nums1.length,nums2.length,nums1,nums2,dp);
        
    }
}