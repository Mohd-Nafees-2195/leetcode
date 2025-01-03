class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length,ans=0,leftSum=0,rightSum=0;
        for(int i=0;i<n;i++){
            rightSum+=nums[i];
        }
        for(int i=0;i<n-1;i++){
            leftSum+=nums[i];
            rightSum-=nums[i];
            if(leftSum>=rightSum)
             ans++;
        }
        return ans;

    }
}