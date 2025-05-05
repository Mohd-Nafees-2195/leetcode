class Solution {
    int MOD=1000000007;
    public int numTilings(int n) {
        int[] dp=new int[1001];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return getWays(n-1,dp);
    }
    public int getWays(int n,int[] dp){
        if(n==0)
         return 1;
        dp[n]=getWays(n-1,dp);
        int ans=0;
        for(int i=0,j=n;i<=n;i++,j--){
            ans+=(int)((long)dp[i]*dp[j])%MOD;
        }
        return ans;
    }
}