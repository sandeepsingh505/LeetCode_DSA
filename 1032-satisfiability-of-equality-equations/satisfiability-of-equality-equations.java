class Solution {
    int[]parent;
    int[]rank;
    public int find(int i ){
        if(i==parent[i]) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int x,int y){
        int x_parent = find(x);
        int y_parent = find(y);;
        if(x_parent==y_parent) return;
    
    if(rank[x_parent]<rank[y_parent]){
        parent[x_parent] = y_parent;
    }else if(rank[x_parent]>rank[y_parent]){
        parent[y_parent] = x_parent;
    }else {
        parent[x_parent] = y_parent;
        rank[y_parent] += 1;
    }
    }
    public boolean equationsPossible(String[] equations) {
        parent = new int[26]; // 26 because english me 26 letters hote hai
        rank = new int[26];
        for(int i = 0;i<26;i++){
            rank[i] = 0;
            parent[i] = i;
        }
        for(int i = 0;i<equations.length;i++){
                String s = equations[i];
                 if(s.charAt(1)== '='){
                union(s.charAt(0)-'a' , s.charAt(3)-'a');
            }
        }
        for(int i = 0;i<equations.length;i++){
            String s = equations[i];
            if(s.charAt(1)=='!'){
                 char first = s.charAt(0);
                 char second = s.charAt(3);
                int first_parent = find(first-'a');
                int second_parent = find(second-'a');
                if(first_parent == second_parent) return false;
            }
        }
        
        return true;
    }
}