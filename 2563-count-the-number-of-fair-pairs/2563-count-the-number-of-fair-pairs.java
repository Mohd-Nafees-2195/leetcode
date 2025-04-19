class Solution {
     public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0; 

        for(int i=0;i<n;i++){
            int l=lowerBound(nums,i+1,n-1,lower-nums[i]);
            int r=upperBound(nums,i+1,n-1,upper-nums[i]);
            ans+=(r-l);
        }
    
        return ans;
    }
    public int lowerBound(int[] arr,int l,int r,int key){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=key) r=mid-1;
            else l=mid+1;
        }
        return r;
    }
    public int upperBound(int[] arr,int l,int r,int key){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]<=key) l=mid+1;
            else r=mid-1;
        }
        return r;
    }
}