class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 0) {
                    rows.add(x);
                    cols.add(y);
                }
            }
        }
        
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if(rows.contains(x) || cols.contains(y)) {
                    matrix[x][y] = 0;
                }
            }
        }
    }
}