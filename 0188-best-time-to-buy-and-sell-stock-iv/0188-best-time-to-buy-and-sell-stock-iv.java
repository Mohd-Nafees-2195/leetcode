class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] curr=new int[2][k+1];
        int[][] next=new int[2][k+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int limit=1;limit<=k;limit++){
                    int profit=0;
                    if(buy==1){
                        int buyKaro=next[0][limit]-prices[ind];
                        int skipKaro=next[1][limit];
                        profit=Math.max(buyKaro,skipKaro);
                    }else{
                        int sellKaro=next[1][limit-1]+prices[ind];
                        int skipKaro=next[0][limit];
                        profit=Math.max(sellKaro,skipKaro);
                    }
                    curr[buy][limit]=profit;
                    next=curr;
                }
            }
        }
        return curr[1][2];
    }
}