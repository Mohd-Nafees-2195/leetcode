class Solution {
    public int minCapability(int[] nums, int k) {
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            l=Math.min(l,nums[i]);
            r=Math.max(r,nums[i]);
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=0;
            for(int i=0;i<n;i++){
                if(nums[i]<=mid){
                    count++;
                    i++;
                }
            }
            if(count>=k){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}