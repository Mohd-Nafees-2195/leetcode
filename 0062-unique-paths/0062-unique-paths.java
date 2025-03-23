class Solution {
    public int uniquePaths(int m, int n) {
        return path(n-1,m-1);
    }
    public int path(int i,int j){
        if(i==0||j==0)
         return 1;
        return path(i-1,j)+path(i,j-1);
    }
}