class Solution {
     public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0; 
        return bound(nums,0,n-1,upper)-bound(nums,0,n-1,lower-1);
    }
    public int bound(int[] arr,int l,int r,int key){
        int ans=0;
        while(l<=r){
            if(arr[l]+arr[r]>key) r--;
            else ans+=r-l++;
        }
        return ans;
    }
}