class Solution {
     public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0; 

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=nums[i]+nums[j];
                if(sum>=lower&&sum<=upper) ans++;
                else if(sum>upper) break;
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     int l = lowerBound(nums, i + 1, n, lower - nums[i]);
        //     int r = upperBound(nums, i + 1, n, upper - nums[i]);
        //     ans += (r - l);
        // }
        
        return ans;
    }
    
    // public static int lowerBound(int[] arr, int left, int right, int target) {
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         if (arr[mid] < target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }
    //     return left;
    // }
    
    // public static int upperBound(int[] arr, int left, int right, int target) {
    //     while (left < right) {
    //         int mid = left + (right - left) / 2;
    //         if (arr[mid] <= target) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }
    //     return left;
    // }
}