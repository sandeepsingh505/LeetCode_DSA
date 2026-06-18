class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
              String sub = s.substring(i,j+1);
              if(isPalindrome(sub)&& sub.length()>ans.length()){
                ans = sub;
              }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s){
        int left = 0 , right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}