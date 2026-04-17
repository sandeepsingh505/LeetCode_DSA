class Solution {
    class Pair{
        int row ,col;
        Pair(int row,int col){
            this.row = row ;
            this.col = col;
        }
    }
    public void bfs(int r,int c,boolean[][]visited,char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new Pair(r,c));
       int[][]direction = {{1,0},{0,1},{-1,0},{0,-1}};
       while(q.size()>0){
        Pair p = q.poll();
        for(int[]d : direction){
            int nr = p.row + d[0];
            int nc = p.col + d[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==false && grid[nr][nc]=='1'){
                visited[nr][nc] = true;
                q.add(new Pair(nr,nc));
            }
        }
       }
    }
    public int numIslands(char[][] grid) {
      int n  =grid.length;
      int m = grid[0].length;
      int count = 0;
      boolean[][] visited = new boolean[n][m];
      for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(!visited[i][j] && grid[i][j]=='1'){
                bfs(i,j,visited,grid);
                count++;
            }
        }
      }
      return count;
        
    }
}