class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int idx ,List<String> curr,List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int end = idx;end<s.length();end++){
            String str = s.substring(idx,end+1);
            if(isPalindrome(str)){
                curr.add(str);
                helper(s,end+1,curr,ans);
            curr.remove(curr.size()-1);

            }
        }
    }
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left <right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}