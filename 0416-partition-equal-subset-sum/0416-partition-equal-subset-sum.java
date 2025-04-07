class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if((sum&1)==1){
            return false;
        }
        int[][] dp=new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return isPos(nums,nums.length-1,sum/2,dp);
    }
    public boolean isPos(int[] nums,int i,int sum,int[][] dp){
        if(sum==0)
         return true;
        if(i<0||sum<0)
         return false;
        if(dp[i][sum]==-1){
            boolean take=isPos(nums,i-1,sum-nums[i],dp);
            boolean nTake=take||isPos(nums,i-1,sum,dp);
            dp[i][sum]=nTake?1:0;
        }
        return dp[i][sum]==1;
    }
}