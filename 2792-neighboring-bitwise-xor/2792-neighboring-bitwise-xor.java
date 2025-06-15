class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xr = 0;
        for (int x: derived) {
            xr = xr ^ x;
        }
        return xr == 0;
    }
}