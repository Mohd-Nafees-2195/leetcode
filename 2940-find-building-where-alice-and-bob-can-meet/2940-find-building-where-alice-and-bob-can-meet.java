class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int hlen = heights.length, qlen = queries.length;
        int[] ans = new int[qlen];
        for (int i = 0; i < qlen; i++) {
            int pre = Math.min(queries[i][0], queries[i][1]);
            int next = Math.max(queries[i][0], queries[i][1]);
            if (heights[pre] < heights[next]) {
                ans[i] = next;
            } else if (queries[i][0] == queries[i][1]) {
                ans[i] = queries[i][0];
            } else {
                int j = next + 1;
                int max = Math.max(heights[queries[i][1]], heights[queries[i][0]]);
                while (j < hlen && max >= heights[j]) {
                    j++;
                }
                if (j < hlen)
                    ans[i] = j;
                else
                    ans[i] = -1;
            }
        }
        return ans;
    }
}