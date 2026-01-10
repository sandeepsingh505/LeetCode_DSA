class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        boolean[][] visited = new boolean[m][n];
        for(int row = 0;row<m;row++){
            for(int col=0;col<n;col++){
                if(visited[row][col]==false && grid[row][col]=='1'){
                    bfs(row,col,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
        public void bfs(int row,int col,char[][]grid,boolean[][]visited){
            int m = grid.length;
            int n = grid[0].length;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row,col));
            while(q.size()>0){
                Pair top = q.remove();
                int a = top.row , b = top.col;
                // top =  row > 0
                if(a>0){
                if(visited[a-1][b]==false && grid[a-1][b]=='1' ){
                    q.add(new Pair(a-1,b));
                    visited[a-1][b] = true;
                    
                }
                }
                // bottom  row+1 < m
                if(a+1<m){
                    if(visited[a+1][b]==false && grid[a+1][b]=='1'){
                        q.add(new Pair(a+1,b));
                        visited[a+1][b] = true;
                    }
                }
                  // left  b>0
                if(b>0){
                    if(visited[a][b-1]==false && grid[a][b-1]=='1'){
                        q.add(new Pair(a,b-1));
                        visited[a][b-1] = true;
                    }
                }
                  // right b<n
                if(b+1<n){
                    if(visited[a][b+1]==false && grid[a][b+1]=='1'){
                        q.add(new Pair(a,b+1));
                        visited[a][b+1] = true;
                    }
                }
            }
        }
    }
