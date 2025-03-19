class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        //int[][] dp=new int[n+1][2];
        int[] curr=new int[2];
        int[] next=new int[2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    int buyKaro=next[0]-prices[ind];
                    int skipKaro=next[1];
                    profit=Math.max(buyKaro,skipKaro);
                }else{
                    int sellKaro=next[1]+prices[ind];
                    int skipKaro=next[0];
                    profit=Math.max(sellKaro,skipKaro);
                }
                curr[buy]=profit;
                next=curr;
            }
        }
        return curr[1];
        //if buy=1 then buy karo else sell karo
    }
}