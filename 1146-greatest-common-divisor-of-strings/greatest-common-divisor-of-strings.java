class Solution {
    public int gcd(int a,int b){
        return (b==0) ? a : gcd(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        int n = str1.length() , m = str2.length();
        int gcd_length = gcd(n,m);
        return str1.substring(0,gcd_length);
    }
}