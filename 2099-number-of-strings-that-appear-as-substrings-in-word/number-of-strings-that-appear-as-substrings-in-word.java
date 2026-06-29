class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String str : patterns) {
            if (isSubstring(word, str)) {
                count++;
            }
        }
        return count;
    }

    public boolean isSubstring(String s1, String s2) {
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String s = s1.substring(i, j + 1);
                if (s.equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }
}