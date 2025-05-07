class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
       // int[][] dp=new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        return getMin(word1,word2,m-1,n-1);
    }
    public int getMin(String s1,String s2,int i,int j){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(s1.charAt(i)==s2.charAt(j))
            return getMin(s1,s2,i-1,j-1);
        int insert = getMin(s1, s2, i, j - 1);
        int delete = getMin(s1, s2, i - 1, j);
        int replace = getMin(s1, s2, i - 1, j - 1);
        return Math.min(insert, Math.min(delete, replace)) + 1;
    }
}