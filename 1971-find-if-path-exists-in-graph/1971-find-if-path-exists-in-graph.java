class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] list=new ArrayList[n];
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        if(source==destination) return true;
        q.add(source);
        while(!q.isEmpty()){
            int v=q.poll();
            if(!visited[v]){
                visited[source]=true;
                for(int vi:list[v]){
                    q.add(vi);
                    visited[vi]=true;
                    if(vi==destination)
                     return true;
                }
            }
        }
        return false;
    }
}