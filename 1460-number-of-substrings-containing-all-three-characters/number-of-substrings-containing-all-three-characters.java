class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0, ans = 0;
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while (mp.size() == 3) {
                ans += (n - j);

                char left = s.charAt(i);
                mp.put(left, mp.get(left) - 1);

                if (mp.get(left) == 0) {
                    mp.remove(left);
                }

                i++;
            }
        }

        return ans;
    }
}