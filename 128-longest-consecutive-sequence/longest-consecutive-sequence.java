class Solution {
    public int longestConsecutive(int[] nums) {
        // Hashset in o(n) and O(n)
        int maxlength = 0;
        HashSet<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        for(int num : st){
            if(!st.contains(num-1)){
               int  curr = num;
               int length = 1;
               while(st.contains(curr+1)){
                curr++;
                length++;
               }
                maxlength = Math.max(maxlength,length);
            }
        }
        return maxlength;
    }
}