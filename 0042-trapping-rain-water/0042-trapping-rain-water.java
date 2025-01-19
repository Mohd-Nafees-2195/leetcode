class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] preMax=new int[n];
        int[] postMax=new int[n];
        preMax[0]=height[0];
        postMax[n-1]=height[n-1];
        for(int i=1,j=n-2;i<n-1;i++,j--){
            preMax[i]=Math.max(preMax[i-1],height[i]);
            postMax[j]=Math.max(postMax[j+1],height[j]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            int minMap=Math.min(postMax[i+1],preMax[i-1]);
            if(minMap-height[i]>0){
                ans+=minMap-height[i];
            }
        }
        return ans;
    }
}