class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            int count = map.getOrDefault(val,0)+1;
            map.put(val,count);
            if(count > 1) {
                return val;
            }
        }
        return -1;
    }
}