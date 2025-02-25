class Solution {
    public int numOfSubarrays(int[] arr) {
        int e = 1, o = 0, ans = 0;
        int mod = 1000000007;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if ((sum & 1) != 0) {
                ans = (ans + e) % mod;
                o++;
            } else {
                ans = (ans + o) % mod;
                e++;
            }
        }
        return ans;
    }
}