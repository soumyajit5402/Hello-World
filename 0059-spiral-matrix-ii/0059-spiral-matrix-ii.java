class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int col_left = 0, col_right = n-1, row_top = 0, row_bottom = n-1, num = 1;
        
        while (num <= n * n) {
            // for row start
            for (int i = col_left; i <= col_right; i++) ans[row_top][i] = num++;
            // for col end
            for (int i = row_top + 1; i <= row_bottom; i++) ans[i][col_right] = num++;
            // for row end
            for (int i = col_right - 1; i >= col_left; i--) ans[row_bottom][i] = num++;
            // for col start
            for (int i = row_bottom - 1; i > row_top; i--) ans[i][col_left] = num++;
            
            row_top++;
            row_bottom--;
            col_left++;
            col_right--;
        }
        return ans;
    }
}