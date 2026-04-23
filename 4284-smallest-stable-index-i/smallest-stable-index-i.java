class Solution {
    public int firstStableIndex(int[] golgappa, int k) {
        int n = golgappa.length;
        if (n == 0) return -1;

        int[] churan = new int[n];
        churan[n - 1] = golgappa[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            churan[i] = Math.min(golgappa[i], churan[i + 1]);
        }

        int dhokla = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dhokla = Math.max(dhokla, golgappa[i]);
            if (dhokla - churan[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}