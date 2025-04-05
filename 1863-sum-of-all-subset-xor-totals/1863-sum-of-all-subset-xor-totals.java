class Solution {
    public int subsetXORSum(int[] nums) {
        return 2*solve(nums,0,nums.length-1);
    }
    public int solve(int[] nums,int sum,int ind){
        if(ind==0)
         return sum;
        return solve(nums,sum,ind-1)+solve(nums,sum^nums[ind],ind-1);
    }
}