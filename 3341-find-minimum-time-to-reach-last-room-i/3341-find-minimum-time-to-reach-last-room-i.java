class Solution {
    public int minTimeToReach(int[][] moveTime) {
        Queue<int[]> q=new PriorityQueue<>((p1,p2)->p1[0]-p2[0]);
        int m=moveTime.length,n=moveTime[0].length;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int count=0;
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            if(arr[1]==m-1&&arr[2]==n-1){
                return arr[0];
            }else if(dp[arr[1]][arr[2]]==-1){
                dp[arr[1]][arr[2]]=arr[0];
                for(int i=0;i<4;i++){
                    int x=dir[i][0]+arr[1];
                    int y=dir[i][1]+arr[2];
                    if(x>=0&&x<m&&y>=0&&y<n){
                        int max=Math.max(arr[0],moveTime[x][y]-arr[0]);
                        q.add(new int[]{max+1,x,y});
                    }
                }
            }

        }
        return -1;
    }
}