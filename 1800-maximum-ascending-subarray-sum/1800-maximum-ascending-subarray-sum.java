class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans=nums[0],max=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                max+=nums[i];
            }else{
                max=nums[i];
            }
            ans=Math.max(ans,max);
        }
        return ans;
    }
}