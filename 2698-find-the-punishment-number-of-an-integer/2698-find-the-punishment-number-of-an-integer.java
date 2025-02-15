class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toString(i * i);
            if (isPunished(0, str, i, 0)) {
                ans += i * i;
            }
        }
        return ans;
    }

    public boolean isPunished(int ind, String str, int i, int sum) {
        int n = str.length();
        if (ind == n)
            return i == sum;
        for (int j = ind; j < n; j++) {
            int val = Integer.parseInt(str.substring(ind, j + 1));
            if (isPunished(j + 1, str, i, sum + val)) {
                return true;
            }
        }
        return false;
    }
}