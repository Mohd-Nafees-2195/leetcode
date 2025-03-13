class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int max=nums[0],n=nums.length,ind=0;
        int qlen=queries.length;
        for(int i=1;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
                ind=i;
            }
        }
        if(max==0)
         return 0;
        int ans=0,sum=0;
        for(int i=0;i<qlen;i++){
            int[] arr=queries[i];
            if(arr[0]<=ind&&ind<=arr[1]){
                sum+=arr[2];
            }
            if(max<=sum)
             return i+1;
        }
        return -1;
        
    }
}