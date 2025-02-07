class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> bolls=new HashMap<>();
        Map<Integer,Integer> colors=new HashMap<>();
        int n=queries.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(colors.size()==limit+1)
             return ans;
            if(!bolls.containsKey(queries[i][0])){
                bolls.put(queries[i][0],queries[i][1]);
                colors.put(queries[i][1],queries[i][0]);
                ans[i]=colors.size();
               
            }else{
                int color=bolls.get(queries[i][0]);
                bolls.put(queries[i][0],queries[i][1]);
                colors.remove(color);
                colors.put(queries[i][1],queries[i][0]);
                ans[i]=colors.size();
            }
        }
        return ans;
    }
}