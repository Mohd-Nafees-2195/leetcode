class Solution {
    public int minTimeToReach(int[][] moveTime) {
        Queue<int[]> q=new PriorityQueue<>((t1,t2)->t1[0]-t2[0]);
        int m=moveTime.length,n=moveTime[0].length;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int count=1;
        q.add(new int[3]);
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int[] arr=q.poll();
                if(arr[1]==m-1&&arr[2]==n-1)
                 return arr[0];
                else if(dp[arr[1]][arr[2]]==-1){
                    dp[arr[1]][arr[2]]=arr[0];
                    for(int i=0;i<4;i++){
                        int x=arr[1]+dir[i][0];
                        int y=arr[2]+dir[i][1];
                        if(x>=0&&x<m&&y>=0&&y<n&&dp[x][y]==-1){
                            int max=Math.max(arr[0],moveTime[x][y]);
                            q.add(new int[]{max+count,x,y});
                        }
                    }
                }
            }
            count=count==1?2:1;
        }
        return -1;
    }
}