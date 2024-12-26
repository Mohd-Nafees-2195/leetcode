class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        return getNoOFExpression(nums,0,0,target);
    }
    public int getNoOFExpression(int[] nums,int i,int sum,int target){
        if(i==nums.length){
            if(sum==target)
             return 1;
            else
             return 0;
        }
        ans=getNoOFExpression(nums,i+1,sum+nums[i],target)+getNoOFExpression(nums,i+1,sum-nums[i],target);
        return ans;
    }
}