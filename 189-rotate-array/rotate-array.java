class Solution {
    public void rotate(int[] nums, int k) {
        // extra array with indexing (i+k)%n;
        int[]temp = new int[nums.length];
        int n = nums.length;
        k = k%n;
        for(int i = 0;i<n;i++){
            temp[(i+k)%n] = nums[i];
        }
        for(int i = 0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}