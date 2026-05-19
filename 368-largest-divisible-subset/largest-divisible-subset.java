class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
              if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
                parent[i] = j;
                }
         }
            if (dp[i] > dp[max]) max = i;
            }
        List<Integer> res = new ArrayList<>();
        for (int i = max; i >= 0; i = parent[i]) {
            res.add(nums[i]);
        }
        return res;
    }
}