class Solution {
    public int Sum(int[]arr){
        int sum = 0;
        for(int ele : arr) sum += ele;
        return sum;
    }
    public boolean isPossible(int[]arr,int days ,int capacity){
        int reqdays = 1;
        int currweight = 0;
        for(int i = 0;i<arr.length;i++){
        if(currweight +arr[i]>capacity){
            reqdays ++;
            currweight = 0;
        }
        currweight += arr[i];
        }
        if(reqdays<=days) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
         for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }
        while(start<end){
            int mid = (end+start)/2;
            if(isPossible(weights,days,mid)){
                end = mid;  
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}