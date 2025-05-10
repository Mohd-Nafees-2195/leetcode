class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int cnt1 = 0, cnt2 = 0;
        int n1 = nums1.length, n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            sum1 += nums1[i];
            if (nums1[i] == 0) cnt1++;
        }

        for (int i = 0; i < n2; i++) {
            sum2 += nums2[i];
            if (nums2[i] == 0) cnt2++;
        }

        System.out.println("sum1 = " + sum1 + ", sum2 = " + sum2);

        if (cnt1 == 0 && cnt2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        }

        if (cnt1 == 0) {
            return sum1 >= sum2+cnt2 ? sum1 : -1;
        }

        if (cnt2 == 0) {
            return sum2 >= sum1+cnt1 ? sum2 : -1;
        }

        // Both have zeroes
        if (sum1 == sum2) {
            return Math.max(sum1 + cnt1, sum2 + cnt2);
        }

        return sum1 > sum2 ? sum1 + cnt1 : sum2 + cnt2;
        }
}