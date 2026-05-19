class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i<n){
            int correctindex = nums[i];
            if(nums[i] < n && nums[i] != nums[correctindex]){
                int temp = nums[i];
                nums[i] = nums[correctindex];
                nums[correctindex] = temp;
            }else{
                i++;
            }
        }
        for(int j = 0;j<n;j++){
            if(nums[j] != j){
                return j;
            }
            
        }
        return n;
    
    }
}