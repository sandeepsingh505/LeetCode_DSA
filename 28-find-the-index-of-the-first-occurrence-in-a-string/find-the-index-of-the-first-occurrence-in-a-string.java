class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0; // haystack ka pointer
        int j = 0; // needle ka pointer
        int[]lps = LPS(needle);
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length()) return i-j;
            }else{
                if(j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;

    }
    public int[] LPS(String pattern){
        int[]lps = new int[pattern.length()];
        int i = 1;  // yeh current element ke liye lps[0] = 0 bcz no prefix;
        int len = 0;   // yeh previous wale ki lenth ke liye
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len>0){
                    len = lps[len-1];
                    
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}