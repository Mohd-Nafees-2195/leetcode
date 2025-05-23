class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.max(nums[i],nums[i]^k);
        }
        return sum;
    }
}