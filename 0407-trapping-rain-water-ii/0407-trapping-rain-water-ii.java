class Solution {
    public int trapRainWater(int[][] heightMap) {
        Queue<Triplet> q=new PriorityQueue<>((t1,t2)->t1.level-t2.level);
        int n=heightMap.length;
        int m=heightMap[0].length;
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        int ans=0,level=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
         q.add(new Triplet(heightMap[i][0],i,0));   
         q.add(new Triplet(heightMap[i][m-1],i,m-1));
         visited[i][0]=true;
         visited[i][m-1]=true;   
        }
        for(int i=1;i<m-1;i++){
         q.add(new Triplet(heightMap[0][i],0,i));   
         q.add(new Triplet(heightMap[n-1][i],n-1,i));
         visited[0][i]=true;
         visited[n-1][i]=true;  
        }
        while(!q.isEmpty()){
            Triplet t=q.poll();
            level=Math.max(level,t.level);
            for(int i=0;i<4;i++){
                int r=t.r+dx[i];
                int c=t.c+dy[i];
                if(r>=0&&r<n&&c>=0&&c<m){
                    if(!visited[r][c]){
                        if(level-heightMap[r][c]>0){
                            ans+=level-heightMap[r][c];
                        }
                        q.add(new Triplet(heightMap[r][c],r,c));
                        visited[r][c]=true;
                    }
                }
            }
        }
        return ans;
    }
    public class Triplet{
        int level,r,c;
        public Triplet(int level,int r,int c){
            this.level=level;
            this.r=r;
            this.c=c;
        }
    }
}