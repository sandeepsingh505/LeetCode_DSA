class Solution {
    public boolean subsetsum(int idx,int[]arr,int target,int[][]dp){
        if(idx==arr.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[idx][target]!=-1){
           return dp[idx][target] == 1;
        }
        boolean skip = subsetsum(idx+1,arr,target,dp);
        boolean ans = false;
        if(target-arr[idx]<0) ans = skip;
        else {
         boolean pick = subsetsum(idx+1,arr,target-arr[idx],dp);
          ans = pick || skip;
        }
        dp[idx][target] = (ans) ? 1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val:nums){
             sum += val;
        }
        if(sum %2!=0)  return false;
        int target = sum/2;
        int dp[][] = new int[nums.length][target+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return subsetsum(0,nums,target,dp);   
    }
}