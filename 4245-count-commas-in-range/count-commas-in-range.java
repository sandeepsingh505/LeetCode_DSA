class Solution {
    public int countCommas(int n) {
        long funkyAnswer = 0;
        long memeBase = 1000;
        int commaGang = 1;

        while (memeBase <= n) {
            long chillEnd = memeBase * 1000 - 1;
            long disco = Math.min(n, chillEnd) - memeBase + 1;
            funkyAnswer += disco * commaGang;
            memeBase *= 1000;
            commaGang++;
        }

        return (int)funkyAnswer;
    }
}