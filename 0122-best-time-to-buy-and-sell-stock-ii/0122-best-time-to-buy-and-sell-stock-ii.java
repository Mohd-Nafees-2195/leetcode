class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return getMaxProfit(prices,1,0,dp);
        //if buy=1 then buy karo else sell karo
    }
    public int getMaxProfit(int[] prices,int buy,int ind,int[][] dp){
        if(ind==prices.length)
         return 0;
        if(dp[ind][buy]!=-1)
         return dp[ind][buy];
        int profit=0;
        if(buy==1){
            int buyKaro=getMaxProfit(prices,0,ind+1,dp)-prices[ind];
            int skipKaro=getMaxProfit(prices,1,ind+1,dp);
            profit=Math.max(buyKaro,skipKaro);
        }else{
            int sellKaro=getMaxProfit(prices,1,ind+1,dp)+prices[ind];
            int skipKaro=getMaxProfit(prices,0,ind+1,dp);
            profit=Math.max(sellKaro,skipKaro);
        }
         dp[ind][buy]=profit;
         return profit;
    }
}