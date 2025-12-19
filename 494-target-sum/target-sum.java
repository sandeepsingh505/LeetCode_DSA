class Solution {
    static int sum;
    public int solve(int nums[],int sum,int res,int target ,int idx,int[][]dp){
        if(idx==nums.length){
            if(res==target) return 1;
            else return 0;
        }if(dp[idx][res+sum]!=-1)return dp[idx][res+sum];
        int add = solve(nums,sum,res+nums[idx],target,idx+1,dp);
        int sub = solve(nums,sum,res-nums[idx],target,idx+1,dp);
        return dp[idx][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int val : nums) sum+= val;
        int[][]dp = new int[nums.length][2*sum+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return solve(nums,sum,0,target,0,dp);
        
    }
}