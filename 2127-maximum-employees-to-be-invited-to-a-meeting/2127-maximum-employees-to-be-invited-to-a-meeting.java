class Solution {
    public int maximumInvitations(int[] favorite) {
        int len = favorite.length;
        int[] follow = new int[len];
        for (int k : favorite) {
            follow[k]++;
        }
        int[] pathlen = new int[len];
        boolean[] visit = new boolean[len];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (follow[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = favorite[i];
            visit[i] = true;
            pathlen[j] = Math.max(pathlen[j], pathlen[i] + 1);
            if (--follow[j] == 0) {
                q.offer(j);
            }
        }
        int maxCycle = 0;
        int sumPath = 0;
        int i = 0;
        while (i < len) {
            if (visit[i]) {
                i++;
            }
            int clen = 0;
            while (i < len && !visit[i]) {
                clen++;
                visit[i] = true;
                i = favorite[i];
            }
            if (clen == 2) {
                sumPath += pathlen[i] + pathlen[favorite[i]] + 2;
            } else {
                maxCycle = Math.max(maxCycle, clen);
            }
            i++;
        }
        return Math.max(maxCycle, sumPath);
    }
}