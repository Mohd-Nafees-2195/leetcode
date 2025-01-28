class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxFish = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0 && !visited[r][c]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, r, c));
                }
            }
        }
        return maxFish;
    }
     private static int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        int fish = grid[r][c];

        fish += dfs(grid, visited, r + 1, c);
        fish += dfs(grid, visited, r - 1, c);
        fish += dfs(grid, visited, r, c + 1);
        fish += dfs(grid, visited, r, c - 1);

        return fish;
    }

}