class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        int currNum = 0;
        String currString = "";
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + ch-'0';
            }else if(ch=='['){
                st1.push(currNum);
                st2.push(currString);
                currNum = 0;
                currString = "";
            }else if(ch==']'){
                int num = st1.pop();
                String str = st2.pop();
                StringBuilder sb = new StringBuilder(str);
                for(int i = 0;i<num;i++){
                    sb.append(currString);
                }
                currString = sb.toString();
                
            }else{
                currString += ch;
            }
        }
        return currString;
    }
}