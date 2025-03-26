class Solution {
    public int minOperations(int[][] grid, int x) {
         int ans=0,m=grid.length,n=grid[0].length;
        int[] arr=new int[m*n];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        k=arr.length-1;
        int l=0;
        while(l<=k){
            if(l==k){
                if(l>0&&arr[l-1]%x!=arr[k]%x){
                    return -1;
                }
            }
            if(arr[l]%x!=arr[k]%x){
                return -1;
            }else{
                int num1=arr[l]/x;
                int num2=arr[k]/x;
                ans+=num2-num1;
            }
            l++;k--;
        }
        return ans;
    }
}