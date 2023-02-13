class Solution {
    public Node construct(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int top = (i == 0) ? 0 : grid[i-1][j];
                int left = (j == 0) ? 0 : grid[i][j-1];
                int diag = (i == 0 || j == 0) ? 0 : grid[i-1][j-1];
                grid[i][j] += (top + left - diag);
            }
        }
        
        return createNode(grid, 0, 0, grid.length-1, grid[0].length-1);
    }
    
    Node createNode(int[][] grid, int start_x, int start_y, int end_x, int end_y) {
        
        int gridSum = grid[end_x][end_y] 
            + ((start_y-1 >= 0) ? (-grid[end_x][start_y-1]) : 0)
            + ((start_x-1 >= 0) ? (-grid[start_x-1][end_y]) : 0)
            + ((start_x-1 >= 0 && start_y-1 >= 0) ? grid[start_x-1][start_y-1] : 0);
        
        boolean isGridAll1 = (gridSum == ((end_x - start_x + 1) * (end_y - start_y + 1)));
        boolean isSingleCell = (start_x == end_x && start_y == end_y);
        
        boolean isLeaf = (gridSum == 0 || isGridAll1 || isSingleCell) ? true : false;  
        boolean value = (gridSum == 0) ? false : true;
        
        Node newNode = new Node (value, isLeaf);
        if (!isLeaf) {
            int mid_x = (start_x + end_x) / 2;
            int mid_y = (start_y + end_y) / 2;
            newNode.topLeft = createNode(grid, start_x, start_y, mid_x, mid_y);
            newNode.topRight = createNode(grid, start_x, mid_y+1, mid_x, end_y);
            newNode.bottomLeft = createNode(grid, mid_x+1, start_y, end_x, mid_y);
            newNode.bottomRight = createNode(grid, mid_x+1, mid_y+1, end_x, end_y);
        }
        return newNode;
    }
}