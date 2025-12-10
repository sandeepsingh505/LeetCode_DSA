import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] cand, int remain, int start, List<Integer> temp, List<List<Integer>> result) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < cand.length; i++) {
            temp.add(cand[i]);
            backtrack(cand, remain - cand[i], i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}