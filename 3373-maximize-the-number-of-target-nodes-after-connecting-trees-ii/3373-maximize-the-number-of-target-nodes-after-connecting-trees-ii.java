
public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildGraph(n, edges1);
        List<List<Integer>> tree2 = buildGraph(m, edges2);

        int[] parity1 = new int[n];
        int[] parity2 = new int[m];

        dfs(tree1, 0, -1, 0, parity1);
        dfs(tree2, 0, -1, 0, parity2);

        int evenCount1 = 0;
        int oddCount1 = 0;
        for (int p : parity1) {
            if (p % 2 == 0) {
                evenCount1++;
            } else {
                oddCount1++;
            }
        }

        int evenCount2 = 0;
        int oddCount2 = 0;
        for (int p : parity2) {
            if (p % 2 == 0) {
                evenCount2++;
            } else {
                oddCount2++;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int tree1Targets = (parity1[i] == 0) ? evenCount1 : oddCount1;
            int tree2Targets = Math.max(evenCount2, oddCount2);
            result[i] = tree1Targets + tree2Targets;
        }

        return result;
    }

    private List<List<Integer>> buildGraph(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private void dfs(List<List<Integer>> graph, int node, int parent, int depth, int[] parity) {
        parity[node] = depth;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(graph, neighbor, node, depth^1, parity);
            }
        }
    }
}
