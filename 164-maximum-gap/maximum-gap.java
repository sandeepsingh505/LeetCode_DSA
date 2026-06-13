class Solution {
    public int maximumGap(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==1) return 0;
        int max = Integer.MIN_VALUE;
        for(int i  = 1 ;i<arr.length;i++){
            max = Math.max(max,arr[i]-arr[i-1]);
        }
        return max;
    }
}