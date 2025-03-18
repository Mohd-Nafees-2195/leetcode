class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sum=nums[0];
        int ans=1,j=0;
        for(int i=1;i<nums.length;i++){
            if(sum+nums[i]==(sum^nums[i])){
                ans=Math.max(ans,i-j+1);
                sum+=nums[i];
            }else{
                sum-=nums[j++];
                while(j<i&&sum+nums[i]!=(sum^nums[i])){
                    sum-=nums[j++];
                }
                sum+=nums[i];
            }
        }
        return ans;
    }
}