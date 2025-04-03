class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int n=nums.length;
        int[] preMax=new int[n];
        int[] postMax=new int[n];
        preMax[0]=nums[0];
        postMax[n-1]=nums[n-1];
        for(int i=1,j=n-2;i<n;i++){
            preMax[i]=Math.max(preMax[i-1],nums[i]);
            postMax[j]=Math.max(postMax[j+1],nums[j]);
        }
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,(preMax[i-1]-nums[i])*(1l*postMax[i+1]));
        }
        return ans;
    }
}