class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer,Boolean> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(dfs(i,graph,map)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int i,int[][] graph,Map<Integer,Boolean> map){
        if(map.containsKey(i)){
            return map.get(i);
        }
        map.put(i,false);
        for(int num:graph[i]){
            if(!dfs(num,graph,map))
             return false;
        }
        map.put(i,true);
        return true;
    }
}