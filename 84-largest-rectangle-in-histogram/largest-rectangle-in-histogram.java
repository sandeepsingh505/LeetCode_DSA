class Solution {
    public int[]previous(int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[]pse = new int[n];
        for(int i = 0;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            pse[i] = (st.size()==0)? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public int[]nextgreater(int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[]nse = new int[n];
        for(int i = n-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i] = (st.size()==0)? n : st.peek();
            st.push(i);

        }
        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[]nse = nextgreater(heights);
        int[]pse = previous(heights);
        int maxarea = 0;
        for(int i = 0;i<n;i++){
            int width = nse[i]-pse[i]-1;
            int area = heights[i]* width;
            maxarea = Math.max(maxarea,area);
        }
        return maxarea;
        
    }
}