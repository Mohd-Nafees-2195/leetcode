class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int n=grid.length,m=grid[0].length;
        int ans=-1,freshO=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                else if(grid[i][j]==1)
                 freshO++; 
            }
        }
        if(freshO==0) return 0;
        while(!q.isEmpty()){
            int size=q.size();
            ans++;
            for(int i=0;i<size;i++){
                int[] arr=q.poll();
                for(int j=0;j<4;j++){
                    int x=arr[0]+dir[j][0];
                    int y=arr[1]+dir[j][1];
                    if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1){
                        grid[x][y]=0;
                        q.add(new int[]{x,y});
                        freshO--;
                    }
                }
            }
        }
        if(freshO!=0)
         return -1;
        return ans;
    }
}