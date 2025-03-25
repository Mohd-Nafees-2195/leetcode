class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
         List<int[]> xIntervals = new ArrayList<>();
        List<int[]> yIntervals = new ArrayList<>();

        for (int[] rect : rectangles) {
            int startX = rect[0], startY = rect[1], endX = rect[2], endY = rect[3];
            xIntervals.add(new int[]{startX, endX});
            yIntervals.add(new int[]{startY, endY});
        }

        if (canPartition(xIntervals)) {
            return true;
        }

        return canPartition(yIntervals);
    }

    private boolean canPartition(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int mergedCount = 0;
        int prevEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (start >= prevEnd) {
                mergedCount++;
                prevEnd = end;
                if (mergedCount >= 3) {
                    return true;
                }
            } else {
                prevEnd = Math.max(prevEnd, end);
            }
        }
        return false;
    }
}