class Solution {
    int search(int[] arr, int key) {
        // code here
        int start = 0;
        int end = arr.length-1;
        int index = -1,firsthalf = -1,secondhalf = -1;
        int res[] = new int[2];
        int n = arr.length;
        while(start<=end){
            int mid = start +(end-start)/2;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                index = mid;
                break;
            }else if(arr[mid]<=arr[end]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        // firsthalf
        start = 0;
        end = index-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==key){
                 firsthalf = mid;
                 break;
            }else if(arr[mid]<key){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        start = index;
        end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==key){
              secondhalf = mid;
              break;
        }else if(arr[mid]<key){
            start = mid+1;
        }else{
            end = mid-1;
        }
        
    }
    res[0] = firsthalf ;
    res[1] = secondhalf;
        if(res[0]==-1){
            return res[1];
        }
        return res[0];
    }
}