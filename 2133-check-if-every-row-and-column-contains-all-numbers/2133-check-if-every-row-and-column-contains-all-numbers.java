class Solution {
    public boolean checkValid(int[][] matrix) {
        long match1 = (matrix.length >= 50) ? ((1l << 50) - 1l) : ((1l << matrix.length) - 1l);
        long match2 = (matrix.length > 50) ? ((1l << (matrix.length - 50)) - 1l) : 0l;
        
        for (int i = 0; i < matrix.length; i++) {
            long check1 = 0l, check2 = 0l;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= 50) check1 = (check1 | (1l << (matrix[i][j] - 1)));
                else check2 = (check2 | (1l << (matrix[i][j] - 51)));
            }
            if (check1 != match1 || check2 != match2) {
                return false;
            }
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
            long check1 = 0, check2 = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] <= 50) check1 = (check1 | (1l << (matrix[i][j] - 1)));
                else check2 = (check2 | (1l << (matrix[i][j] - 51)));
            }
            if (check1 != match1 || check2 != match2) {
                return false;
            }
        }
        
        return true;
    }
}