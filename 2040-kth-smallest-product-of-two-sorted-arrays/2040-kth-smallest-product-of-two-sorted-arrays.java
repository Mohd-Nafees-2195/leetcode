class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = -1_000_000_000L * 1_000_000_000L;
        long h =  1_000_000_000L * 1_000_000_000L; 
        long ans=0;
        while(l<=h){
            long midPro=l+(h-l)/2;
            long cntSmallest=cntSmallest(nums1,nums2,midPro);
            if(cntSmallest>=k){
                ans=midPro;
                h=midPro-1;
            }else{
                l=midPro+1;
            }
        }
        return ans;
    }
    private long cntSmallest(int[] A, int[] B, long x) {
        long count = 0;
        int n = B.length;

        for (int a : A) {
            if (a > 0) {
                int l = 0, r = n - 1, pos = -1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * B[m] <= x) {
                        pos = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += pos + 1;
            } else if (a < 0) {
                int l = 0, r = n - 1, pos = n;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * B[m] <= x) {
                        pos = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += n - pos;
            } else {
                if (x >= 0)
                    count += n;
            }
        }

        return count;
    }
    
}