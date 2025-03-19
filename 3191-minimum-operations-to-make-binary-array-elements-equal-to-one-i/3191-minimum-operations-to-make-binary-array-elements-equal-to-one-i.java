class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]=nums[i+1]==0?1:0;
                nums[i+2]=nums[i+2]==0?1:0;
                ans++;
                if(i==nums.length-3){
                    if(nums[i+1]==0||nums[i+2]==0)
                     return -1;

                }
            }
        }
        // if(ans==0)
        //  return -1;
        return ans;
    }
}