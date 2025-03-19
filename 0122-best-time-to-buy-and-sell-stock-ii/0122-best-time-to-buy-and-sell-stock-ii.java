class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    int buyKaro=dp[ind+1][0]-prices[ind];
                    int skipKaro=dp[ind+1][1];
                    profit=Math.max(buyKaro,skipKaro);
                }else{
                    int sellKaro=dp[ind+1][1]+prices[ind];
                    int skipKaro=dp[ind+1][0];
                    profit=Math.max(sellKaro,skipKaro);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
        //if buy=1 then buy karo else sell karo
    }
}