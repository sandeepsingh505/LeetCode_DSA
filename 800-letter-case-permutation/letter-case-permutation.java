class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        String ip = s;
        String op ="";
        solve(ip,op,ans);
        return ans;
        
    }
    public static void solve(String ip , String op , ArrayList<String> ans){
        if(ip.length()==0){
            ans.add(op);
            return;
        }
        char ch = ip.charAt(0);
        if(Character.isLetter(ch)){
        String op1 = op + Character.toLowerCase(ch);
        String op2 = op + Character.toUpperCase(ch);
            ip = ip.substring(1);
            solve(ip,op1,ans);
            solve(ip,op2,ans);
        }else{
          String op1 = op + ch;
          ip = ip.substring(1);
            solve(ip,op1,ans);

        }
        
    }
}