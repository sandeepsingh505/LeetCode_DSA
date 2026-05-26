class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            String ch = operations[i];
              if(ch.equals("D")){
                st.push(st.peek()*2);
              }else if(ch.equals("C")){
                st.pop();
              }else if(ch.equals("+")){
                int top = st.pop();
                int newtop = top + st.peek();
                st.push(top);
                st.push(newtop);
              }
              else{
                st.push(Integer.parseInt(ch));
              }
        }

        int sum = 0;
        while(st.size()>0){
            sum += st.pop();
        }
        
        return sum;
    }
}