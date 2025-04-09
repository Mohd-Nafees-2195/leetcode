class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++)
         ans=Math.min(ans,path(grid,grid.length-1,i));
        return ans;
    }
    public int path(int[][] grid,int i,int j){
        if(i==0)
         return grid[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<grid.length;k++){
            if(k!=j)
             ans=Math.min(ans,path(grid,i-1,k)+grid[i][j]);
        }
        // if(ans!=Integer.MAX_VALUE)
        //  return ans+grid[i][j];
        return ans;
    }
}