class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int size=days.length;
        int[] dp=new int[size];
        return getMinCost(days,costs,size,0,dp);
    }
    public int getMinCost(int[] days,int[] cost,int n,int i,int[] dp){
        if(i>=n)
         return 0;
        if(dp[i]!=0)
         return dp[i];
        int oneDay=cost[0]+getMinCost(days,cost,n,i+1,dp);
        int j=i;
        int maxDay=days[i]+6;
        while(j<n&&days[j]<=maxDay){j++;}
        int sevenDay=cost[1]+getMinCost(days,cost,n,j,dp);
        j=i;
        maxDay=days[i]+29;
        while(j<n&&days[j]<=maxDay){j++;}
        int thirtyDay=cost[2]+getMinCost(days,cost,n,j,dp);
        dp[i]=Math.min(oneDay,Math.min(sevenDay,thirtyDay));

        return dp[i];

    }
}