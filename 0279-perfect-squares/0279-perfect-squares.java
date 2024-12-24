class Solution {
    public int numSquares(int n) {
        int[] dp=new int[10001];
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int x=1;x*x<=i;x++){
                dp[i]=Math.min(dp[i],dp[i-x*x]+1);
            }
        } 
        return dp[n];
    }
}