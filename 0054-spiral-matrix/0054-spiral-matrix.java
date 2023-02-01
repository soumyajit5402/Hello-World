class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> container = new ArrayList<>();
        int col_left = 0, col_right = matrix[0].length - 1, row_top = 0, row_bottom = matrix.length - 1;
        
        while (col_left <= col_right && row_top <= row_bottom) {
            // for row top
            for (int i = col_left; i <= col_right; i++) container.add(matrix[row_top][i]);
            // for col right
            for (int i = row_top + 1; i <= row_bottom; i++) container.add(matrix[i][col_right]);
            // for row bottom
            if (row_top != row_bottom)
                for (int i = col_right - 1; i >= col_left; i--) container.add(matrix[row_bottom][i]);
            // for col left
            if (col_left != col_right)
                for (int i = row_bottom - 1; i > row_top; i--) container.add(matrix[i][col_left]);
            
            row_top++;
            row_bottom--;
            col_left++;
            col_right--;
        }
        return container;
    }
}