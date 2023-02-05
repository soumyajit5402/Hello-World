class Solution {
    int[] x_diff = new int[] { 1, -1, 0, 0 };
    int[] y_diff = new int[] { 0, 0, 1, -1 };
    
    int[] x_diff_all = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] y_diff_all = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
    
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return computePerimeter(grid, i, j);        
            }
        }
        return 0;
    }
    
    private int computePerimeter(int[][] grid, int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + x_diff[i];
            int newY = y + y_diff[i];
            if (isPerimeter(grid, newX, newY)) count++;
        }
        
        grid[x][y] = -1;
        for (int i = 0; i < 8; i++) {
            int newX = x + x_diff_all[i];
            int newY = y + y_diff_all[i];
            if (isEligibleCell(grid, newX, newY)) {
                count += computePerimeter(grid, newX, newY);
            }
        }
        return count;
    }
    
    private boolean isEligibleCell(int[][] grid, int x, int y) {
        return !(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1);
    }
    
    private boolean isPerimeter(int[][] grid, int x, int y) {
        return (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0);
    }
}