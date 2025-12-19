class Solution {
    public int solve(int nums[],int res,int target ,int idx){
        if(idx==nums.length){
            if(res==target) return 1;
            else return 0;
        }
        int add = solve(nums,res+nums[idx],target,idx+1);
        int sub = solve(nums,res-nums[idx],target,idx+1);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,0,target,0);
        
    }
}