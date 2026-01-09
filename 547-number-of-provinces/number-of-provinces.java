class Solution {
    public int findCircleNum(int[][] adjmatrix){
        int n = adjmatrix.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(i,visited,adjmatrix);
                count++;
            }
        }
        return count;
        
    }
    public void bfs(int start,boolean[]visited,int[][]matrix){
        int n = matrix.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(q.size()>0){
            int top = q.remove();
            for(int i = 0;i<n;i++){
                if(matrix[top][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}