class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char current = s.charAt(i);
            if(Character.isLetterOrDigit(current)){
                sb.append(Character.toLowerCase(current));
            }
        }
        String original = sb.toString();
        String reversed = sb.reverse().toString();
        return original.equals(reversed);

    }
}