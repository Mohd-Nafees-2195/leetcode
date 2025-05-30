class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length+1;
        List<List<Integer>> adj=new ArrayList<>();
        createList(adj,edges);
        int[] dist1=new int[n+1];
        int[] dist2=new int[n+1];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dfs(dist1,adj,node1,0);
        dfs(dist2,adj,node2,0);
        int minDis=-1;
        int currMinDis=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            //System.out.println(dist1[i]+" - "+dist2[i]);
            int max=Math.max(dist1[i],dist2[i]);
            if(currMinDis>max){
                currMinDis=max;
                minDis=i;
            }
        }
        return minDis;
    }
    public void dfs(int[] dist,List<List<Integer>> adj,int i,int d){
        dist[i]=d;
        for(int v:adj.get(i)){
            dfs(dist,adj,v,d+1);
        }
    }
    public void createList(List<List<Integer>> adj,int[] edges){
        for(int i=0;i<edges.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1){
                adj.get(i).add(edges[i]);
            }
        }
    }
}