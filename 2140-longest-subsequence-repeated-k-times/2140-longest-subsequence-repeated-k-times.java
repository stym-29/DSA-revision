import java.util.*;

class Solution {
    public boolean solve(String sub, String s, int k) {
        int i = 0, count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == sub.charAt(i)) {
                i++;
                if (i == sub.length()) {
                    i = 0;
                    count++;
                    if (count == k) return true;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        String ans = "";
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String next = curr + ch;
                if (solve(next, s, k)) {
                    ans = next;
                    queue.add(next);
                }
            }
        }
        return ans;
    }
}
