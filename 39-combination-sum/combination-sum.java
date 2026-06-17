class Solution {
    public void solve(int idx,int[]arr,List<Integer> curr ,List<List<Integer>> ans,int target){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        if(idx==arr.length || target<0) return ;
        // pick 
        curr.add(arr[idx]);
        solve(idx,arr,curr,ans,target-arr[idx]);
        // backtrack
        curr.remove(curr.size()-1);
        // notpick
        solve(idx+1,arr,curr,ans,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
           solve(0,candidates,new ArrayList<>(),ans,target);
        return ans;
    }
}