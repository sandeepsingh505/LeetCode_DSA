import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] cand, int remain, int idx, List<Integer> temp, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < cand.length; i++) {
            if (i > idx && cand[i] == cand[i - 1]) continue;
            if (cand[i] > remain) break;
            temp.add(cand[i]);
            backtrack(cand, remain - cand[i], i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}