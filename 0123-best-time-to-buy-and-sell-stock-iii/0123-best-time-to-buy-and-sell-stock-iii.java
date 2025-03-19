class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        return getMaxProfit(prices,1,0,2,dp);
        //if buy=1 then buy the stock else sell the stock
    }
    public int getMaxProfit(int[] prices,int buy,int ind,int limit,int[][][] dp){
        if(ind==prices.length)
         return 0;
        if(limit==0)
         return 0;
        if(dp[ind][buy][limit]!=0)
         return dp[ind][buy][limit];
        int profit=0;
        if(buy==1){
            int buyKaro=getMaxProfit(prices,0,ind+1,limit,dp)-prices[ind];
            int skipKaro=getMaxProfit(prices,1,ind+1,limit,dp);
            profit=Math.max(buyKaro,skipKaro);
        }else{
            int sellKaro=getMaxProfit(prices,1,ind+1,limit-1,dp)+prices[ind];
            int skipKaro=getMaxProfit(prices,0,ind+1,limit,dp);
            profit=Math.max(sellKaro,skipKaro);
        }
        return dp[ind][buy][limit]=profit;
    }
}