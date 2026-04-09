class Solution {
    public int minpath(int row , int col ,int[][] mat, int[][] dp){
        int m = mat.length;
        int n = mat[0].length;
        if (col < 0 || col >= n)
            return Integer.MAX_VALUE;
        if (row == m - 1)
            return mat[row][col];
        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];
        int diagLeft = minpath(row + 1, col - 1, mat, dp);
        int down = minpath(row + 1, col, mat, dp);
        int diagRight = minpath(row + 1, col + 1, mat, dp);
        return dp[row][col] =
            mat[row][col] + Math.min(diagLeft, Math.min(down, diagRight));
    }
    public int minFallingPathSum(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for (int[] row : dp)
            Arrays.fill(row,Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < mat[0].length; j++) {
            ans = Math.min(ans, minpath(0, j, mat, dp));
        }
        return ans;
    }
}