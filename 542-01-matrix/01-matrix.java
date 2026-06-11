class Solution {
    class Pair{
        int row, col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length , m = mat[0].length;
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m ;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                }else if(mat[i][j]==1){
                    dist[i][j] = -1;
                }
            }
        }
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size()>0){
            Pair p = q.poll();
            for(int[]d: directions){
                int nr = p.row + d[0];
                int nc = p.col + d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && dist[nr][nc]==-1){
                    dist[nr][nc] = dist[p.row][p.col]+ 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return dist;
        
    }
}