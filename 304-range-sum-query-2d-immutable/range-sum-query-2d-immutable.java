class NumMatrix {
  int[][]seg;
  int n,m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        seg = new int[n][m];
        build(matrix);
    }
    public void build(int[][]matrix){
        // if(matrix.length==0 || matrix== null || matrix[0].length==0) return;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                seg[i][j] = matrix[i][j];
                if(i>0) seg[i][j] += seg[i-1][j]; // top 
                if(j>0) seg[i][j] += seg[i][j-1];
                if(i>0 && j>0) seg[i][j] -= seg[i-1][j-1];
            }
        }  
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = seg[row2][col2];
        if (row1 > 0) sum -= seg[row1 - 1][col2];
        if (col1 > 0) sum -= seg[row2][col1 - 1];
        if (row1 > 0 && col1 > 0) sum += seg[row1 - 1][col1 - 1];

        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */