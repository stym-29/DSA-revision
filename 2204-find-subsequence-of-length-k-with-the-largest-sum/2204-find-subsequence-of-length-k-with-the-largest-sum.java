class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int size = nums.length;
        int sorted[] = Arrays.copyOf(nums, size);
        Arrays.sort(sorted);
        int threshold = sorted[size - k];
        int thresholdCount = 0;
        for (int i = size - k; i < size; i++) {
            if (sorted[i] == threshold) thresholdCount++;
        }
        int result[] = new int[k];
        int index = 0;
        for (int num : nums) {
            if (num > threshold) {
                result[index++] = num;
            } else if (num == threshold && thresholdCount > 0) {
                result[index++] = num;
                thresholdCount--;
            }
            if (index == k) break;
        }
        return result;
    }
}
