class Solution {
    public boolean helper(int[]arr,int sum,int idx,Boolean[][]dp){
        if(idx==0) return arr[0] == sum;
        if(sum==0) return true;
        if(dp[idx][sum]!=null) return dp[idx][sum]; 
        if(arr[idx]<=sum){
             dp[idx][sum] = (helper(arr,sum-arr[idx],idx-1,dp) ||helper(arr,sum,idx-1,dp));
        }else{
         dp[idx][sum]=helper(arr,sum,idx-1,dp);
        }
         return dp[idx][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        Boolean[][]dp = new Boolean[nums.length][(sum/2)+1];
     for(Boolean[]row : dp)Arrays.fill(row,null);
        if(sum%2==0){
            return helper(nums,sum/2,nums.length-1,dp);
        }
        return false;
        
    }
}