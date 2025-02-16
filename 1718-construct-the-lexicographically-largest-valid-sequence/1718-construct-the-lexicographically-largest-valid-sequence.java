class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean[n + 1];
        int[] ans = new int[2 * n - 1];
        backtrack(0, used, ans, n);
        return ans;
    }

    public boolean backtrack(int ind, boolean[] used, int[] ans, int n) {
        while (ind < ans.length && ans[ind] != 0)
            ind++;
        if (ind == ans.length)
            return true;
        for (int i = n; i >= 1; i--) {
            if (used[i])
                continue;
            if (i == 1) {
                ans[ind] = i;
                used[i] = true;
                if (backtrack(ind + 1, used, ans, n))
                    return true;
                ans[ind] = 0;
                used[i] = false;
            } else if (ind + i < ans.length && ans[ind + i] == 0) {
                ans[ind] = i;
                ans[ind + i] = i;
                used[i] = true;
                if (backtrack(ind + 1, used, ans, n))
                    return true;
                ans[ind] = 0;
                ans[ind + i] = 0;
                used[i] = false;

            }
        }
        return false;
    }
}