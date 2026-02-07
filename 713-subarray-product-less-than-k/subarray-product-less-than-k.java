class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0 , end = 0;
        int product = 1;
        int count = 0;
        if(k <=1) return 0;
        while(end<nums.length){
            product *= nums[end];
            while(product>= k){
                product /= nums[start];
                start++;  
            }
             if(product<k){
            count += end - start+1;
           
        }
        end++;
      
        
    }  return count;
}
}