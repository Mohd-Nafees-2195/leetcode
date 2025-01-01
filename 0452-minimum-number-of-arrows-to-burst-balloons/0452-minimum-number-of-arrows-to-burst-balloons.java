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
        int commonEnd=points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]<=commonEnd){
                commonEnd=Math.min(commonEnd,points[i][1]);
            }else{
                ans++;
                commonEnd=points[i][1];
            }
        }
        return ans;
    }
}