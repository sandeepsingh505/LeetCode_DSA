class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalsum = n * (n+1)/2;
        int arrsum = 0;
        for(int num : nums) arrsum += num;
        return totalsum-arrsum;
    }
}