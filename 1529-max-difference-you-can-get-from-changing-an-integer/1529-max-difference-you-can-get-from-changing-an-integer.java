class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        return getMax(s) - getMin(s);
    }

    private int getMax(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < '9') {
                return Integer.parseInt(s.replace(c + "", "9"));
            }
        }
        return Integer.parseInt(s);
    }

    private int getMin(String s) {
        int n = s.length();
        char firstDigit = s.charAt(0);

        if (firstDigit != '1') {
            return Integer.parseInt(s.replace(firstDigit + "", "1"));
        } else {
            for (int i = 1; i < n; i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    return Integer.parseInt(s.replace(c + "", "0"));
                }
            }
            return Integer.parseInt(s);
        }
    }
}
