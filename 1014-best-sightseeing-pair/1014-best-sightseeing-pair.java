class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int[] postMax=new int[n];
        postMax[n-1]=values[n-1]-(n-1);
        for(int i=n-2;i>=0;i--){
            postMax[i]=Math.max(postMax[i+1],values[i]-i);
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
            ans=Math.max(ans,values[i]+i+postMax[i+1]);
        }
        return ans;
    }
}