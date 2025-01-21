class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long ans=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            grid[0][i]=grid[0][i]+grid[0][i-1];
            grid[1][i]=grid[1][i]+grid[1][i-1];
        }
        long r1=0,r2=0;
        ans=grid[0][n-1]-grid[0][0];
        for(int i=1;i<n;i++){
            r1=grid[1][i-1];
            r2=grid[0][n-1]-grid[0][i];
            ans=Math.min(ans,Math.max(r1,r2));
        }
        return ans;
    }
}