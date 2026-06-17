class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[]ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for(int i = 0;i<n;i++){
            // remove out of window indicies  
            while(dq.size()>0 && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            // remove smaller element 
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
        
        
    }
}