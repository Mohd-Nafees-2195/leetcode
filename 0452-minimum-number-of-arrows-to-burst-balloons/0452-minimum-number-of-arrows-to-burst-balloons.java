class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==1)
         return 1;
        Arrays.sort(points,(p1,p2)->{
            if(p1[0]<p2[0])
             return -1;
            else if(p1[0]>p2[0])
             return 1;
            else
             return 0;
        });
        int ans=1;
        int[] interval=points[0];
        for(int i=1;i<n;i++){
            if(points[i][0]<=interval[1]){
                interval[0]=Math.max(interval[0],points[i][0]);
                interval[1]=Math.min(interval[1],points[i][1]);
            }else{
                ans++;
                interval=points[i];
            }
        }
        return ans;
    }
}