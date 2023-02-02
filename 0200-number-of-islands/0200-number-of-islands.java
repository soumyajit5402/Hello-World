class Solution {
    int[] x_diff = new int[] { 1, -1, 0, 0 };
    int[] y_diff = new int[] { 0, 0, 1, -1 };
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    trackIslandBFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void trackIslandBFS(char[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == '0') return;
        arr[i][j] = '0';
        for (int a = 0; a < 4; a++) {
            int newX = i + x_diff[a];
            int newY = j + y_diff[a];
            trackIslandBFS(arr, newX, newY);
        }
    }
}