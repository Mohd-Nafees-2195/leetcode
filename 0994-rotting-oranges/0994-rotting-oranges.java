class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int n=grid.length,m=grid[0].length;
        int[][] time=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    time[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            for(int i=0;i<4;i++){
                int x=arr[0]+dir[i][0];
                int y=arr[1]+dir[i][1];
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1){
                    grid[x][y]=0;
                    q.add(new int[]{x,y});
                    time[x][y]+=time[arr[0]][arr[1]]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
                ans=Math.max(ans,time[i][j]);
            }
        }
        return ans;
    }
}