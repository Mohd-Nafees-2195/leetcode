class Solution {

    public int numSquares(int n) {
        int sqrt=(int)Math.sqrt(n);
        if(sqrt*sqrt==n)
         return 1;
        while(n%4==0){
            n=n/4;
        }
        if(n%8==7)
         return 4;
        for(int i=1;i*i<n;i++){
            int num=n-(i*i);
            sqrt=(int)Math.sqrt(num);
            if(sqrt*sqrt==num)
             return 2;
        }
        return 3;
    }


    //Recursive Approach
    //  public int numSquares(int n) {
    //     int[] dp=new int[n+1];
    //     return minCount(n,dp);
    // }
    // public int minCount(int n,int[] dp){
    //     if(n<=0){
    //         return 0;
    //     }
    //     if(dp[n]!=0){
    //         return dp[n];
    //     }
    //     dp[n]=n;
    //     for(int x=1;x*x<=n;x++){
    //         dp[n]=Math.min(dp[n],minCount(n-x*x,dp)+1);
    //     }
    //     return dp[n];
    // }

    //Iterative Approach
    // public int numSquares(int n) {
    //     int[] dp=new int[n+1];
    //     for(int i=1;i<=n;i++){
    //         dp[i]=i;
    //         for(int x=1;x*x<=i;x++){
    //             dp[i]=Math.min(dp[i],dp[i-x*x]+1);
    //         }
    //     } 
    //     return dp[n];
    // }
}