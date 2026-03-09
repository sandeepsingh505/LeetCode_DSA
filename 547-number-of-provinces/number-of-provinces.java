class Solution {
    class DSU{
        int parent[];
       DSU(int n){
    parent = new int[n];
    for(int i = 0; i < n; i++){
        parent[i] = i;
    }
}
        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pa!=pb) parent[pb] = pa;
        }
        public int find(int i){
            if(parent[i]==i){
                return i;
            }
            return parent[i] = find(parent[i]);
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU obj = new DSU(n);
        int count = n;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1){
              if(obj.find(i) != obj.find(j)){
            obj.union(i, j);
             count--;
    }
}
        }
       
    }
    return count;
    }
    }