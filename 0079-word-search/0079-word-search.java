class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordExists(board, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean wordExists(char[][] board, int x, int y, boolean[][] visited, String word, int index) {
        if (index >= word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (visited[x][y] == true) return false;
        if (board[x][y] != word.charAt(index)) return false;
        
        visited[x][y] = true;
        int[] x_diff = new int[] { 1, -1, 0, 0 };
        int[] y_diff = new int[] { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + x_diff[i];
            int newY = y + y_diff[i];
            if (wordExists(board, newX, newY, visited, word, index + 1)) return true;    
        }
        visited[x][y] = false;
        return false;
    }
}