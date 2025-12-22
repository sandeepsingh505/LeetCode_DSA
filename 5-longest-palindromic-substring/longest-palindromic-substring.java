class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
    if (n == 0) return "";

    int[][] dp = new int[n][n];
    int maxLen = 1;
    int start = 0;

    for (int k = 0; k < n; k++) {
        int i = 0, j = k;
        while (j < n) {

            if (i == j) {
                dp[i][j] = 1;
            } 
            else if (j == i + 1) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                }
            } 
            else {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }

            // 👉 longest substring update
            if (dp[i][j] == 1 && (j - i + 1) > maxLen) {
                maxLen = j - i + 1;
                start = i;
            }

            i++;
            j++;
        }
    }
    return s.substring(start, start + maxLen);
}

}