class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1,n=nums.length;
        int max=1;

        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])
             max++;
            else
             max=1;
            ans=Math.max(ans,max);
        }
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1])
             max++;
            else
             max=1;
            ans=Math.max(ans,max);
        }
        return ans;
    }
}