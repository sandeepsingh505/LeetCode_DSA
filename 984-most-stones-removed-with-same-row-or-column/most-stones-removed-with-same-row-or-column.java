class Solution {
        public void union(int a,int b,int[]parent,int[]rank){
            int a_parent = find(a,parent);
            int b_parent = find(b,parent);
            if(a_parent==b_parent) return;
            if(rank[a_parent]<rank[b_parent]){
                parent[a_parent] = b_parent;
            }  else if(rank[a_parent]>rank[b_parent]){
                parent[b_parent] = a_parent;
            }else {
                parent[b_parent] = a_parent;
                rank[a_parent]++;
            }
        }
        public int find(int i,int[]parent){
            if(i==parent[i]) return i;
            return parent[i] = find(parent[i],parent);
        }
    
    
    public int removeStones(int[][] stones){
        int n = stones.length;
      int[] parent = new int[n];
      int[] rank = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        for(int i = 0;i<stones.length;i++){
            int row = stones[i][0];
            int col = stones[i][1];
        
        for(int j = i+1;j<stones.length;j++){
            int currrow = stones[j][0];
            int currcol = stones[j][1];
        
        if(row == currrow || col == currcol){
            union(i,j,parent,rank);
        }
        }}
        int component = 0;
     for(int i =0;i<stones.length;i++){
        if(parent[i]==i) component++;
     }
     return stones.length-component;
    }
} 