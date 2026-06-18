class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(candidate==nums[i]){
                count++;
            }else if(count==0){
                candidate = nums[i];
            }else{
                count--;
            }
        }
        count=0;
        for(int val : nums){
            if(candidate==val) count++;
            
        }
        return (count>n/2)? candidate : 0;
    }
}