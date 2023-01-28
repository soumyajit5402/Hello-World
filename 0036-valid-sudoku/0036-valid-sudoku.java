class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (!validateRows(board)) return false;
        if (!validateCols(board)) return false;
        if (!validateSquares(board)) return false;
        return true;
    }
    
    boolean validateRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> container = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (container.contains(board[i][j])) return false;
                    container.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    boolean validateCols(char[][] board) {
        for (int j = 0; j < 9; j++) {
            Set<Character> container = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (container.contains(board[i][j])) return false;
                    container.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    boolean validateSquares(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 9 squares in total
                Set<Character> container = new HashSet<>();
                for (int a = i*3; a < i*3+3; a++) {
                    for (int b = j*3; b < j*3+3; b++) {
                        if (board[a][b] != '.') {
                            if (container.contains(board[a][b])) return false;
                            container.add(board[a][b]);
                        }
                    }
                }
            }
        }
        return true;
    }
}