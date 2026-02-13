class Solution {
    class Pair{
        int row , col ;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void bfs(int r,int c ,boolean[][]visited,int[][]mat){
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }
                else if(mat[i][j]==1){
                    visited[i][j]=true;
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
                    if(nr>=0 && nc>=0 && nr<n && nc<m && mat[nr][nc]==1 && visited[nr][nc]==true){
                        mat[nr][nc] = mat[curRow][curCol] + 1;
                        visited[nr][nc] = false;
                        q.add(new Pair(nr,nc));
                        
                    }
                }
            
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][]visited = new boolean[n][m];
        bfs(0,0,visited,mat);
        return mat;
    }
}