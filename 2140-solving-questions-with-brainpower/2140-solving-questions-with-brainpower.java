class Solution {
    public long mostPoints(int[][] questions) {
        int[] dp=new int[questions.length];
        Arrays.fill(dp,-1);
        return maxPoints(questions,0,dp);
    }
    public int maxPoints(int[][] questions,int i,int[] dp){
        if(i>=questions.length)
         return 0;
        if(dp[i]==-1){
            dp[i]=Math.max(maxPoints(questions,i+questions[i][1]+1,dp)+questions[i][0],maxPoints(questions,i+1,dp));
        }
       return dp[i];
    }
}