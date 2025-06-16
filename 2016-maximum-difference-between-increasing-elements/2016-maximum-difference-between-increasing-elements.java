class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int[] preMax=new int [n];
        preMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            preMax[i]=Math.max(preMax[i+1],nums[i]);
        }
        int ans=-1;
        for(int i=0;i<n-1;i++){
            ans=Math.max(ans,preMax[i+1]-nums[i]);
        }
        return ans;
    }
}