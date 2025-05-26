class Solution {
    int ans=0;
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length(),m=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
        }
        boolean[] visited=new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                Map<Character,Integer> map=new HashMap<>();
                if (dfs(adj,i, visited, recStack,colors,map)) return -1;
            }
        }
        return ans;
    }
    private boolean dfs(List<List<Integer>> adj,int node, boolean[] visited, boolean[] recStack,String s,Map<Character,Integer> map) {
        visited[node] = true;
        recStack[node] = true;
        map.put(s.charAt(node),map.getOrDefault(s.charAt(node),0)+1);
        ans=Math.max(ans,map.get(s.charAt(node)));
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && dfs(adj,neighbor, visited, recStack,s,map))
                return true;
            else if (recStack[neighbor])
                return true; 
        }
        map.put(s.charAt(node),map.getOrDefault(s.charAt(node),0)-1);

        recStack[node] = false;
        return false;
    }
}