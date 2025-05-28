class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1=new ArrayList<>();
        List<List<Integer>> adj2=new ArrayList<>();
        int n=edges1.length+1,m=edges2.length+1;
        for(int i=0;i<n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj2.add(new ArrayList<>());
        }
        for(int[] arr:edges1){
            adj1.get(arr[0]).add(arr[1]);
            adj1.get(arr[1]).add(arr[0]);
        }
        for(int[] arr:edges2){
            adj2.get(arr[0]).add(arr[1]);
            adj2.get(arr[1]).add(arr[0]);
        }
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            int size=adj2.get(i).size();
            list.add(new int[]{i,size});
        }
        Collections.sort(list,(a,b)->b[1]-a[1]);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            boolean[] visited=new boolean[n];
            int t1=dfs(i,adj1,0,k,visited);
            int t2=0;
            for(int j=0;j<list.size();j++){
                visited=new boolean[m];
                int[] arr=list.get(j);
                int max=Math.max(t2,dfs(arr[0],adj2,1,k,visited));
                if(max==t2) break;
                else t2=max;
            }
            System.out.println(t1+" - "+t2);
            ans[i]=t1+t2;
        }
        return ans;
    }
    public int dfs(int v,List<List<Integer>> adj,int ecnt,int k,boolean[]  visited){
        if(ecnt>k||visited[v]) return 0;
        visited[v]=true;
        int cnt=1;
        for(int i:adj.get(v)){
         cnt+=dfs(i,adj,ecnt+1,k,visited);
        }
        return cnt;
    }
}