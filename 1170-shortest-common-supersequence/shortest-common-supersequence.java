class Solution {
    public String lcs(String a, String b ){
        int[][] dp= new int[a.length()+1][b.length()+1];
        for(int i = 1;i<=a.length();i++){
            for(int j = 1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int i = a.length(),j = b.length();
         StringBuilder sb = new StringBuilder("");
        while(i> 0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                 sb.append(a.charAt(i-1));
                 i--;
                 j--;
                 }
            else if(dp[i][j-1]>dp[i-1][j]) j--;
            else i--;;
        }
        sb.reverse();
        return sb.toString();
    
        }
       
    public String shortestCommonSupersequence(String a, String b) {
        String lc = lcs(a,b);
        int i = 0,j=0,k=0;
        String sb = "";
        while(i<a.length()&& j<b.length()&& k<lc.length()){
            while(a.charAt(i)!=lc.charAt(k)){
                sb +=a.charAt(i); i++;
           
            }while(b.charAt(j)!=lc.charAt(k)){
                sb +=b.charAt(j); j++;
            }
            sb +=lc.charAt(k);
            i++;j++;k++;
        }
        while(j<b.length()){
            sb+=b.charAt(j);j++;
        }while(i<a.length()){
            sb +=a.charAt(i);i++;
        }
        return sb;
     
    }
}