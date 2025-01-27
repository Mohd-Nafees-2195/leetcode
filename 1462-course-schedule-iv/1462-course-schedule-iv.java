class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int qlen=queries.length;
        int prelen=prerequisites.length;
        List<Boolean> ans=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        boolean[][] graph=new boolean[numCourses][numCourses];
        for(int i=0;i<prelen;i++){
            int key=prerequisites[i][0];
            int value=prerequisites[i][1];
            graph[key][value]=true;
            map.put(key,value);
        }
        for(int i=0;i<prelen;i++){
            int key=prerequisites[i][0];
            int value=prerequisites[i][1];
            while(map.containsKey(value)){
                graph[key][map.get(value)]=true;
                value=map.get(value);
            }
        }

        for(int i=0;i<qlen;i++){
            if(graph[queries[i][0]][queries[i][1]]){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}