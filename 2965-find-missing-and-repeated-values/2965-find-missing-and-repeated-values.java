class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set=new HashSet<>();
        int n=grid.length;
        int[] ans=new int[2];
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!set.contains(grid[i][j])){
                    set.add(grid[i][j]);
                    sum+=grid[i][j];
                }else{
                    ans[0]=grid[i][j];
                }
            }
        }
        int totalSum=(n*n*(n*n+1))/2;
        ans[1]=totalSum-sum;
        return ans;
    }
}