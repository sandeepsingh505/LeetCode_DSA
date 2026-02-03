class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currmax = nums[0];
        int currmin = nums[0];
        int maxsum = nums[0];
        int minsum = nums[0];
        for(int i = 1;i<n;i++){
            currmax = Math.max(currmax+nums[i],nums[i]);
            maxsum = Math.max(maxsum,currmax);
        }
         for(int i = 1;i<n;i++){
            currmin = Math.min(currmin+nums[i],nums[i]);
            minsum = Math.min(minsum,currmin);
        } int totalsum = 0;
        for(int i = 0;i<n;i++){
            totalsum += nums[i];
        }
        if(maxsum<0) return maxsum;
       
        else return Math.max(maxsum,totalsum-minsum);
    }
}