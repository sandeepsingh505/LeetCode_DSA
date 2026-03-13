class Solution {
    public int Maxvalue(int[]arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(max<arr[i]) max = arr[i];
        }
        return max;
    }
    public boolean isPossible(int[]arr,int hour,int speed){
        int time = 0;
        for(int i = 0;i<arr.length;i++){
            time += Math.ceil((double)arr[i]/speed);
        }
        if(time<=hour) return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int k) {
        int start = 1;
        int end = Maxvalue(piles);
        int ans = 0;
        while(start<=end){
            int mid = (end +start)/2;
            if(isPossible(piles,k,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}