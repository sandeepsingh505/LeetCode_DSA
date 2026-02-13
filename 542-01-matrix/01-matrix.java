class Solution {
    class Pair{
        int row , col ;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void bfs(int r,int c ,int[][]mat){
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }
                else if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            
            }
        }
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        while(q.size()>0){
                Pair p = q.poll();
                int curRow = p.row;
                int curCol = p.col;
                for(int[]d : direction ){
                    int nr = curRow + d[0];
                    int nc = curCol + d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==-1){
                        mat[nr][nc] = mat[curRow][curCol] + 1;
                        q.add(new Pair(nr,nc));
                        
                    }
                }
            
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        bfs(0,0,mat);
        return mat;
    }
}