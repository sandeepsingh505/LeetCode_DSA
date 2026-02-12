class Solution {
    class Pair{
        int row , col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++){
            if(board[i][0]=='O') bfs(board,i,0);  // 0th coloumn 
            if(board[i][m-1]=='O') bfs(board,i,m-1);// m-1th coloumn
        }
        for(int i = 0;i<m;i++){
            if(board[0][i]=='O') bfs(board,0,i);
            if(board[n-1][i]=='O') bfs(board,n-1,i);
        }

         // convert it to orginal form
         for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]=='A'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] ='X';
                }
            }
         }
        
    }
    public void bfs(char[][]board,int r , int c){
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        board[r][c] = 'A';
        while(q.size()>0){
            Pair p = q.poll();
            int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[]d : direction){
                int newrow = p.row + d[0];
                int newcol = p.col + d[ 1];
                if(newrow>=0 && newcol>=0 && newcol<m && newrow<n && board[newrow][newcol]=='O'){
                    board[newrow][newcol] = 'A';
                    q.add(new Pair(newrow,newcol));
                }
            }
        }
    }
}