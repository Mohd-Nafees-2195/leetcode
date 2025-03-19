class Solution {
    public int maxProfit(int[] prices) {
        int ans=0,n=prices.length;
        int max=prices[n-1];
        for(int i=n-2;i>=0;i--){
            ans=Math.max(ans,max-prices[i]);
            max=Math.max(max,prices[i]);
        }
        return ans;
    }
}