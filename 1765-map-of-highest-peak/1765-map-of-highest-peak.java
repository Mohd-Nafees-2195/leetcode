class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length,m=isWater[0].length;
        int ans[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        int dir[][]={{0,-1},{0,1},{1,0},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int r=cell[0],c=cell[1];
            int currHeight=ans[r][c];
            for(int i=0;i<4;i++){
                int newr=r+dir[i][0];
                int newc=c+dir[i][1];
                if(newr>=0&&newr<n&&newc>=0&&newc<m&&ans[newr][newc]==-1){
                    ans[newr][newc]=currHeight+1;
                    q.add(new int[]{newr,newc});
                }
            }
        }
        return ans;
    }
}