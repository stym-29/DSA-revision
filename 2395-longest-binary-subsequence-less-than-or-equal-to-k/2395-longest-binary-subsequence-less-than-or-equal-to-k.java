public class Solution {
    public int longestSubsequence(String s, int k) {
        int zeros = 0, ones = 0;
        long value = 0, pow = 1;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (value + pow > k) continue;
                value += pow;
                ones++;
            }
            pow <<= 1;
            if (pow > k) break;
        }

        return zeros + ones;
    }
}
