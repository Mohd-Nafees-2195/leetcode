class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int j=i+1;
            while(j<n&&prices[i]<prices[j]){
                j++;
            }
            if(j==n){
                ans[i]=prices[i];
            }else{
                ans[i]=prices[i]-prices[j];
            }
        }
        return ans;
    }
}