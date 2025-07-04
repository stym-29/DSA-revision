class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0;
        long len = 1;

        for (int i = 0; i < operations.length; i++) {
            len *= 2;
            if (len >= k) {
                for (int j = i; j >= 0; j--) {
                    long half = len / 2;
                    if (k > half) {
                        k -= half;
                        if (operations[j] == 1) shift++;
                    }
                    len /= 2;
                }
                break;
            }
        }

        return (char) ((shift % 26) + 'a');
    }
}
