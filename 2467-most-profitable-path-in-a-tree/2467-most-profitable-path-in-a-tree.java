class Solution {
    static class Result {
        int maxProfit = Integer.MIN_VALUE;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        // Construct the graph (Tree)
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Find Bob's path to root
        Map<Integer, Integer> bobArrivalTime = new HashMap<>();
        findBobPath(graph, bob, -1, 0, bobArrivalTime);

        // DFS to calculate the max profit for Alice
        Result result = new Result();
        dfs(0, -1, 0, 0, graph, amount, bobArrivalTime, result);
        
        return result.maxProfit;
    }

    private boolean findBobPath(List<Integer>[] graph, int node, int parent, int time, Map<Integer, Integer> bobArrivalTime) {
        bobArrivalTime.put(node, time);
        if (node == 0) return true;

        for (int neighbor : graph[node]) {
            if (neighbor != parent && findBobPath(graph, neighbor, node, time + 1, bobArrivalTime)) {
                return true;
            }
        }
        bobArrivalTime.remove(node);
        return false;
    }

    private void dfs(int node, int parent, int time, int profit, List<Integer>[] graph, int[] amount, 
                     Map<Integer, Integer> bobArrivalTime, Result result) {
        if (bobArrivalTime.containsKey(node)) {
            int bobTime = bobArrivalTime.get(node);
            if (bobTime > time) {
                profit += amount[node];  // Alice reaches first, take full amount
            } else if (bobTime == time) {
                profit += amount[node] / 2;  // Both reach at same time, take half
            }
        } else {
            profit += amount[node];  // Only Alice reaches
        }

        boolean isLeaf = true;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                dfs(neighbor, node, time + 1, profit, graph, amount, bobArrivalTime, result);
            }
        }

        // If it's a leaf, update max profit
        if (isLeaf) {
            result.maxProfit = Math.max(result.maxProfit, profit);
        }
    }
}