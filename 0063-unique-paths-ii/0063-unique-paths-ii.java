class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        return getPath(obstacleGrid,m-1,n-1,dp);
    }
    public int getPath(int[][] obstacleGrid,int i,int j,int[][] dp){
        if(i<0||j<0)
         return 0;
        if(obstacleGrid[i][j]==1)
         return 0;
        if(i==0||j==0)
         return 1;
        if(dp[i][j]!=0)
         return dp[i][j];
        return dp[i][j]=getPath(obstacleGrid,i-1,j,dp)+getPath(obstacleGrid,i,j-1,dp);
    }
}