class Solution {

    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o, p) -> o[0] - p[0]);
        Integer[][] dp = new Integer[moveTime.length][moveTime[0].length];
         queue.offer(new int[3]);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
           if (poll[1] == moveTime.length - 1 && poll[2] == moveTime[0].length - 1) {
                return poll[0];
            } else if (poll[1] >= 0 && poll[1] < moveTime.length && poll[2] >= 0 && poll[2] < moveTime[0].length && dp[poll[1]][poll[2]] == null) {
                dp[poll[1]][poll[2]] = poll[0];
                queue.offer(new int[] { Math.max(poll[0], poll[1] > 0 ? moveTime[poll[1] - 1][poll[2]] : 0) + 1, poll[1] - 1, poll[2] });
                queue.offer(new int[] { Math.max(poll[0], poll[2] > 0 ? moveTime[poll[1]][poll[2] - 1] : 0) + 1, poll[1], poll[2] - 1 });
                queue.offer(new int[] { Math.max(poll[0], poll[2] < moveTime[0].length - 1 ? moveTime[poll[1]][poll[2] + 1] : 0) + 1, poll[1], poll[2] + 1 });
                queue.offer(new int[] { Math.max(poll[0], poll[1] < moveTime.length - 1 ? moveTime[poll[1] + 1][poll[2]] : 0) + 1, poll[1] + 1, poll[2] });
            }
        }
        return -1;
    }
}