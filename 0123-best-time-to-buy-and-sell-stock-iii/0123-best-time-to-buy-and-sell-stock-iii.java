class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=2;limit++){
                    int profit=0;
                    if(buy==1){
                        int buyKaro=dp[ind+1][0][limit]-prices[ind];
                        int skipKaro=dp[ind+1][1][limit];
                        profit=Math.max(buyKaro,skipKaro);
                    }else{
                        int sellKaro=dp[ind+1][1][limit-1]+prices[ind];
                        int skipKaro=dp[ind+1][0][limit];
                        profit=Math.max(sellKaro,skipKaro);
                    }
                    dp[ind][buy][limit]=profit;
                }
            }
        }
        return dp[0][1][2];
        //if buy=1 then buy the stock else sell the stock
    }
}