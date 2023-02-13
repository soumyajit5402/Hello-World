/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), cols = dimensions.get(1);
        
        int ans = -1, col_left = 0, col_right = cols - 1;
        while (col_left <= col_right) {
            int col_mid = col_left + (col_right - col_left) / 2;
            for (int row = 0; row < rows; row++) {
                if (binaryMatrix.get(row, col_mid) == 1) {
                    ans = col_mid;
                    col_right = col_mid - 1;
                    break;
                }
            }
            if (col_right >= col_mid) col_left = col_mid + 1;
        }
        return ans;
    }
}