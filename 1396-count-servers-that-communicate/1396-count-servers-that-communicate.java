class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int total = 0;

        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    total++;
                }

        
        int isolated = 0;
        for (int i = 0; i < m; ++i)
            if (row[i] == 1)
                for (int j = 0; j < n; ++j)
                    if (col[j] == 1 && grid[i][j] == 1)
                        isolated++;

        return total - isolated;
    }
}