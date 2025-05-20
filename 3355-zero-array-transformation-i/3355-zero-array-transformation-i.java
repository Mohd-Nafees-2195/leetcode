class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff=new int[n];
        for(int i=0;i<queries.length;i++){
            int[] arr=queries[i];
            diff[arr[0]]++;
            if(arr[1]+1<n){
                diff[arr[1]+1]=-1;
            }
        }
        if(nums[0]>diff[0])
         return false;
        for(int i=1;i<n;i++){
            diff[i]=diff[i]+diff[i-1];
            if(nums[i]>diff[i])
             return false;
        }
        return true;
    }
}