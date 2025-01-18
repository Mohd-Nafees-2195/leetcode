class Solution {
    public int minCost(int[][] grid) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        Queue<MinCost> q = new PriorityQueue<>((m1, m2) -> Integer.compare(m1.cost, m2.cost));
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        q.add(new MinCost(0, 0, 0));
        while (!q.isEmpty()) {
            MinCost minCost = q.poll();
            int x = minCost.x;
            int y = minCost.y;
            if (!visited[x][y]) {
                visited[x][y] = true;
                if (x == n - 1 && y == m - 1) {
                 return minCost.cost;
                }
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                        int cost = (i + 1) == grid[x][y] ? minCost.cost : 1 + minCost.cost;
                        q.add(new MinCost(cost, newX, newY));
                    }

                }
            }
        }
        return 0;
    }

    public class MinCost {
        int cost, x, y;

        public MinCost(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }
}