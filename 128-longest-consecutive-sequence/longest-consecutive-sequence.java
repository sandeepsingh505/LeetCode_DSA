class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxlength = 1;       
     int currlength = 1;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1 == nums[i+1]){
                currlength++;
            }else{
                currlength=1;

            }
            maxlength = Math.max(maxlength,currlength);
        }
        return maxlength;
    }
}