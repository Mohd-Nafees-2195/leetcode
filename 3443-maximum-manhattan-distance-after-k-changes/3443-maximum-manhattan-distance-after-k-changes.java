class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            int base = Math.abs(x) + Math.abs(y);
            int maxPossible = Math.min(base + 2 * k, i + 1);
            ans = Math.max(ans, maxPossible);
        }
        return ans;
    }
}