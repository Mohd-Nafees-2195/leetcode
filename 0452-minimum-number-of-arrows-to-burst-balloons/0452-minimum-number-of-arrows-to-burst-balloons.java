class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2)->{
            if(p1[0]<p2[0])
             return -1;
            else if(p1[0]>p2[0])
             return 1;
            else{
                if(p1[1]<p2[1])
                 return -1;
                else
                 return 1;
            }
        });
        int ans=1,n=points.length;
        int i=0,j=1;
        while(j<n){
            if(points[i][1]<points[j][0]){
                ans++;
                i=j;
            }
            j++;
        }
        return ans;
    }
}