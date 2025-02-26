class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int maxSum=0;
        int minSum=0;
        for(int i=0;i<nums.length;i++){
          maxSum+=nums[i];
          if(ans<maxSum)
           ans=maxSum;
          if(maxSum<0)
           maxSum=0;
        }
        for(int i=0;i<nums.length;i++){
          minSum+=nums[i];
          if(ans<(-minSum))
           ans=-minSum;
          if(minSum>0)
           minSum=0;
        }
        return ans;
    }
}