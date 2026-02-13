class Solution {
    class Pair{
        int row , col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int bfs(int r,int c,int[][]grid){
        int minutes =0;
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(q.size()>0){
            int size = q.size();
            boolean rottanthislevel = false;
            for(int i = 0;i<size;i++){
            Pair p = q.poll();
            for(int[]d:direction){
                int nr = p.row +d[0];
                int nc = p.col +d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    fresh--;
                    q.add(new Pair(nr,nc));
                    rottanthislevel = true;

                }
            }
            }
           if(rottanthislevel) minutes++;
        }
         
         return fresh == 0 ? minutes : -1;
    }
    public int orangesRotting(int[][] grid) {
        
      return   bfs(0,0,grid);
    
        
    }
}