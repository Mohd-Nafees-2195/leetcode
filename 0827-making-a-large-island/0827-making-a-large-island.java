import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; // Start assigning IDs from 2 (since 0 and 1 are already used)
        Map<Integer, Integer> islandSizes = new HashMap<>(); // Maps island ID to its size

        // Step 1: Assign unique IDs to islands and calculate their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    islandId++;
                }
            }
        }

        // Step 2: Check each 0 for potential expansion
        int maxSize = islandSizes.isEmpty() ? 0 : islandSizes.values().stream().max(Integer::compare).get();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    // Check all 4 directions
                    if (i > 0 && grid[i - 1][j] != 0) neighbors.add(grid[i - 1][j]); // Up
                    if (i < n - 1 && grid[i + 1][j] != 0) neighbors.add(grid[i + 1][j]); // Down
                    if (j > 0 && grid[i][j - 1] != 0) neighbors.add(grid[i][j - 1]); // Left
                    if (j < n - 1 && grid[i][j + 1] != 0) neighbors.add(grid[i][j + 1]); // Right

                    // Sum the sizes of neighboring islands
                    int currentSize = 1; // The current 0 being converted to 1
                    for (int neighborId : neighbors) {
                        currentSize += islandSizes.get(neighborId);
                    }
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
        }

        return maxSize;
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId; // Assign the island ID
        int size = 1;
        // Explore all 4 directions
        size += dfs(grid, i + 1, j, islandId);
        size += dfs(grid, i - 1, j, islandId);
        size += dfs(grid, i, j + 1, islandId);
        size += dfs(grid, i, j - 1, islandId);
        return size;
    }
}