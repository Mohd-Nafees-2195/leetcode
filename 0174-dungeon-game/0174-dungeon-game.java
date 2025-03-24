class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length,n=dungeon[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return minH(dungeon,0,0,m,n,dp);
    }
    public int minH(int[][] dungeon,int i,int j,int m,int n,int[][] dp){
        if(i==m-1&&j==n-1)
         return Math.max(1,1-dungeon[i][j]);
        if(i>=m||j>=n)
         return Integer.MAX_VALUE;
        if(dp[i][j]==-1){
            dp[i][j]=Math.max(1,Math.min(minH(dungeon,i+1,j,m,n,dp),minH(dungeon,i,j+1,m,n,dp))-dungeon[i][j]);
        }
        return dp[i][j];
    }
}