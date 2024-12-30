class Solution {
    final int MOD=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp=new int[high+1];
        return getCount(low,high,zero,one,0,dp);
    }
    public int getCount(int low, int high, int zero, int one,int len,int[] dp){
        if(len>high)
         return 0;
        if(dp[len]!=0)
         return dp[len];
        if(len>=low)
         dp[len]=1;
        dp[len]+= getCount(low,high,zero,one,len+zero,dp)+getCount(low,high,zero,one,len+one,dp);
        return dp[len]%MOD;
    }
}