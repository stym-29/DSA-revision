import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        long sum;
        int index;

        Node(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.sum != other.sum) {
                return Long.compare(this.sum, other.sum);
            }
            // Tie-breaker: choose the leftmost index
            return Integer.compare(this.index, other.index);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] a = new long[n];
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
            prev[i] = i - 1;
            next[i] = (i + 1 < n) ? i + 1 : -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Node(a[i] + a[i + 1], i));
        }

        int bad = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) bad++;
        }

        int ops = 0;

        while (bad > 0 && !pq.isEmpty()) {
            Node top = pq.poll();
            int i = top.index;
            long sum = top.sum;

            if (removed[i] || next[i] == -1) continue;

            int j = next[i];
            if (removed[j] || a[i] + a[j] != sum) continue;

            int pi = prev[i];
            int nj = next[j];

            if (pi != -1 && a[pi] > a[i]) bad--;
            if (a[i] > a[j]) bad--;
            if (nj != -1 && a[j] > a[nj]) bad--;

            a[i] = sum;
            removed[j] = true;
            next[i] = nj;
            if (nj != -1) prev[nj] = i;

            if (pi != -1 && a[pi] > a[i]) bad++;
            if (nj != -1 && a[i] > a[nj]) bad++;

            if (pi != -1) pq.add(new Node(a[pi] + a[i], pi));
            if (nj != -1) pq.add(new Node(a[i] + a[nj], i));

            ops++;
        }

        return ops;
    }
}