class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int maxarea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<=n;i++){
            int currheight =(i==n)?0:arr[i];
            while(!st.isEmpty() && currheight<=arr[st.peek()]){
                int height = arr[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i-st.peek()-1;
                }
                maxarea = Math.max(maxarea,height*width);
            }
            st.push(i);
        }
        return maxarea;
    }
}