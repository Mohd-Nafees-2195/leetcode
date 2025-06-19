class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        if(n<=1)
            return 1;
        Arrays.sort(nums);
        int count=1,num=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]-num>k)
            {
                num=nums[i];
                count++;
            }
        }
        return count;
    }
}