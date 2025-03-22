class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Track visited nodes
        boolean[] visited = new boolean[n];
        int ans = 0;

        // Step 3: Perform DFS to find connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, i, visited, component);

                // Step 4: Check if the component is complete
                if (isCompleteComponent(graph, component)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(List<List<Integer>> graph, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, component);
            }
        }
    }

    // Check if the component forms a complete graph
    private boolean isCompleteComponent(List<List<Integer>> graph, List<Integer> component) {
        int size = component.size();
        int expectedEdges = size * (size - 1) / 2;
        int actualEdges = 0;

        // Count actual edges in the component
        for (int node : component) {
            actualEdges += graph.get(node).size();
        }

        // Each edge is counted twice in an undirected graph
        return actualEdges / 2 == expectedEdges;
    }
}