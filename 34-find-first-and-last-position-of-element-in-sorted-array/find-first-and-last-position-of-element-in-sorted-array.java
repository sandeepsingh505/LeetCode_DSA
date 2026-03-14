class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        int startocc = -1;
        int endocc = -1;
        int start = 0;
        int end = nums.length-1;
        // for firstoccurence ke liye kr raha hoon
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                startocc = mid;
                end = mid-1; 
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        // for last occurence ke liye
        start = 0;
        end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                endocc = mid;
                start = mid+1;
            }else if(nums[mid]<target){
                start = mid +1;
            }else{
                end = mid-1;
            }

        }
        res[0] = startocc;
        res[1] = endocc;
        return res;
    }
}