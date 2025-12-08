class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        int open = n;
        int closed = n;
        String op = "";
        solve(open,closed,op,ans);
        return ans;
        
    }
    public static void solve(int open , int close , String op,ArrayList<String> ans){
        if(open==0 && close == 0){
            ans.add(op);
            return ;
        }
        if(open!=0){
            String op1 = op;
            op1 = op1 + "(";
            solve(open-1,close,op1,ans);
        }
        if(open<close){
            String op2 = op;
            op2 = op2 + ")";
            solve(open,close-1,op2,ans);
        }
    }
}