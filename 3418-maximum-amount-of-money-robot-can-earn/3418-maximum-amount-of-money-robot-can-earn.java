class Solution {
    public int maximumAmount(int[][] coins) {
        return maximumAmount(0, 0, 0, new Integer[coins.length][coins[0].length][3], coins);
    }

    private int maximumAmount(int i, int j, int k, Integer[][][] dp, int[][] coins) {
        if (i == coins.length || j == coins[0].length) {
            return -1000000000;
        } else if (i == coins.length - 1 && j == coins[0].length - 1) {
            return coins[i][j] < 0 && k < 2 ? 0 : coins[i][j];
        } else if (dp[i][j][k] == null) { 
            dp[i][j][k] = Math.max(coins[i][j] + Math.max(maximumAmount(i + 1, j, k, dp, coins), maximumAmount(i, j + 1, k, dp, coins)), coins[i][j] < 0 && k < 2 ? Math.max(maximumAmount(i + 1, j, k + 1, dp, coins), maximumAmount(i, j + 1, k + 1, dp, coins)) : -1000000000);
        }
        return dp[i][j][k];
    }
}