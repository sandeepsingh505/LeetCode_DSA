class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Character> st1  = new HashSet<>();
        HashSet<Character> st2 = new HashSet<>();
        int n = word.length();
        for(int i = 0;i<n;i++) {
                if(Character.isLowerCase(word.charAt(i))){
                    st1.add(word.charAt(i));
                  }else{
                    st2.add(word.charAt(i));
                  }
        }
        for(char num : st1){
            if(st2.contains(Character.toUpperCase(num))){
                count++;
            }
        }
        return count;
    }
}