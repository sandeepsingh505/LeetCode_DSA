class Solution {
    public int solve(int i,int j , String s1,String s2,int[][]dp){
        int  n = s1.length() , m = s2.length();
        if(i==n){  // mtlb word1 empty ya katam ho gaya hai toh insertion chaiye jitne word2 hai 
          return  m-j;
        }
          if(j==m){  // mtlb word2 empty ya katam ho gaya hai toh deletion chaiye jitne word1 hai 
          return  n-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){// character match ho gaya toh i+1,j+1
            return dp[i][j] =  solve(i+1,j+1,s1,s2,dp);
        }else{
            int insert = 1 + solve(i,j+1,s1,s2,dp);
            int delete = 1 + solve(i+1,j,s1,s2,dp);
            int replace = 1 + solve(i+1,j+1,s1,s2,dp);
            return dp[i][j] =  Math.min(insert,(Math.min(delete,replace)));
        }
    }
    public int minDistance(String word1, String word2) {
        int[][]dp = new int[word1.length()+1][word2.length()+1];
        for(int[]row : dp) Arrays.fill(row,-1);
        return solve(0,0,word1,word2,dp);
    }
}