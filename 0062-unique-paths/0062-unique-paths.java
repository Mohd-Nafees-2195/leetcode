class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return path(m-1,n-1,dp);
    }
    public int path(int i,int j,int[][] dp){
        if(i==0||j==0)
         return 1;
        if(dp[i][j]!=0)
         return dp[i][j];
        return dp[i][j]=path(i-1,j,dp)+path(i,j-1,dp);
    }
}