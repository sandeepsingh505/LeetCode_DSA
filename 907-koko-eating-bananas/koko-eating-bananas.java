class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = 0;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
        int ans = high;
        while(low <=high){
            int mid  = low + (high-low)/2;
            if(isValid(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[]piles,int speed,int h){
        long hour = 0;
        for(int pile : piles){
            hour += (pile+speed-1)/speed;
        }
        return (hour<=h);
    }
}