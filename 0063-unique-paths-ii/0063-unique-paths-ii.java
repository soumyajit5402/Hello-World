class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = 0, y = 0, len = obstacleGrid.length, wid = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[len-1][wid-1] == 1) return 0; // edge cases
        
        int[][] ansGrid = new int[len][wid];
        ansGrid[len - 1][wid - 1] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = wid - 1; j >= 0; j--) {
                if (i == len-1 && j == wid-1) continue;
                ansGrid[i][j] = getCount(i, j+1, ansGrid, obstacleGrid) + getCount(i+1, j, ansGrid, obstacleGrid); 
            }
        }
        return ansGrid[0][0];
    }
    
    int getCount(int x, int y, int[][] ansGrid, int[][] obstacleGrid) {
        if (x >= ansGrid.length || y >= ansGrid[0].length) return 0;
        if (obstacleGrid[x][y] == 1) return 0;
        return ansGrid[x][y];
    }
}