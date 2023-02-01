class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length, bre = matrix.length;
        
        if (target < matrix[0][0] || target > matrix[bre-1][len-1]) return false;
        
        int left = 0, right = matrix.length - 1;
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) right = mid - 1;
            else if (matrix[mid][0] < target) left = mid;
        }
        
        if (matrix[right][0] == target || matrix[left][0] == target) return true;
        
        int row = (target > matrix[right][0]) ? right : left;
        
        left = 0;
        right = matrix[0].length - 1;
        while (right - left > 1) {
            int mid = left + ((right - left) >> 1);
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) right = mid - 1;
            else if (matrix[row][mid] < target) left = mid + 1;
        }
        if (matrix[row][right] == target || matrix[row][left] == target)
            return true;
        return false;
    }
}