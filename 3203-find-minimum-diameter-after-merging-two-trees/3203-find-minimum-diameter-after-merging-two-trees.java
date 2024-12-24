class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> tree1=createAdjacensyList(edges1);
        List<List<Integer>> tree2=createAdjacensyList(edges2);

        int d1=findDiameter(tree1);
        int d2=findDiameter(tree2);
        System.out.println(d1+" - "+d2);
        return Math.max(Math.max(d1,d2),(d1+1)/2+(d2+1)/2+1);
        
    }
     public static int findDiameter(List<List<Integer>> adjacencyList) {
        int farthestNode = bfs(adjacencyList, 0, null);
        int diameter = bfs(adjacencyList, farthestNode, null);
        return diameter;
    }

    public static int bfs(List<List<Integer>> adjacencyList, int startNode, int[] distances) {
        int n = adjacencyList.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        queue.add(startNode);
        visited[startNode] = true;

        int farthestNode = startNode;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[currentNode] + 1;
                    queue.add(neighbor);

                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        if (distances != null) {
            System.arraycopy(dist, 0, distances, 0, n);
        }
        return distances == null ? dist[farthestNode] : farthestNode;
    }
    public List<List<Integer>> createAdjacensyList(int[][] edges){
        int max=1,n=edges.length;
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<n;i++){
            max=Math.max(max,Math.max(edges[i][0],edges[i][1]));
        }
        for(int i=0;i<=max;i++){
            lists.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        return lists;
    }
}