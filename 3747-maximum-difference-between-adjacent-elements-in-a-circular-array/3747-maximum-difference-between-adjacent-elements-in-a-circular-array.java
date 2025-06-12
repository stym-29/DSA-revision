class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for( int i = 0; i < nums.length - 1; i++ ){
            int diff = Math.abs(nums[i+1] - nums[i]);
            max = Math.max(max, diff);
        }
        int circularDiff = Math.abs(nums[nums.length -1] - nums[0]);
        max = Math.max(max, circularDiff);
        return max;
    }
}