class Solution {
    public int maxProfit(int[] prices) {
        return getMaxProfit(prices,true,0);
        //if buy=true then buy karo else sell karo
    }
    public int getMaxProfit(int[] prices,boolean buy,int ind){
        if(ind==prices.length)
         return 0;
        int profit=0;
        if(buy){
            int buyKaro=getMaxProfit(prices,false,ind+1)-prices[ind];
            int skipKaro=getMaxProfit(prices,true,ind+1);
            profit=Math.max(buyKaro,skipKaro);
        }else{
            int sellKaro=getMaxProfit(prices,true,ind+1)+prices[ind];
            int skipKaro=getMaxProfit(prices,false,ind+1);
            profit=Math.max(sellKaro,skipKaro);
        }
        return profit;
    }
}