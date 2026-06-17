class Solution {
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0,minutes = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][]directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size()>0){
            boolean rottanthislevel = false;
            int size = q.size();
            for(int i = 0;i<size;i++){
                Pair p = q.poll();
                for(int []d : directions){
                    int nr = p.row + d[0];
                    int nc = p.col + d[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new Pair(nr,nc));
                        rottanthislevel = true;
                    }
                }
            }
            if(rottanthislevel) minutes++;
        }
        return (fresh==0) ? minutes : -1;
        
    }
}