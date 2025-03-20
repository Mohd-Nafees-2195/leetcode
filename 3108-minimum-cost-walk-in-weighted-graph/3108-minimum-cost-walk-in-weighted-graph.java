class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[][] mat=new int[n][n];
       
        int qlen=query.length,elen=edges.length;
        int[] ans=new int[qlen];
        int minAnd=edges[0][2];
        // for(int i=0;i<elen;i++){
        //     int j=edges[i][0],k=edges[i][1];
        //     mat[j][k]=egdes[i][2];
        //     mat[k][j]=egdes[i][2];
        //     if(map.containsKey(j)){
        //         map.get(j).add(k);
        //         if(map.containsKey(k)){
        //             map.get(k).add(j);
        //         }else{
        //             Set<Integer> set=new HashSet<>();
        //             set.add(j);
        //             map.put(k,set);
        //         }
        //     }else{
        //         Set<Integer> set=new HashSet<>();
        //         set.add(k);
        //         map.put(j,set);
        //         if(map.containsKey(k)){
        //             map.get(k).add(j);
        //         }else{
        //             Set<Integer> set=new HashSet<>();
        //             set.add(j);
        //             map.put(k,set);
        //         }
        //     }
        // }
        // for(int i=1;i<elen;i++){
        //     minAnd=minAnd&edges[i][2];
        // }
        // for(int i=0;i<qlen;i++){
        //     int s=Math.min(query[i][0],query[i][1]);
        //     int d=Math.max(query[i][0],query[i][1]);

        //     int and=minAnd;            
        //     while(s<=d){
        //         int next=s+1;
        //         int check=0;
        //         if(mat[s][next]==0&&mat[next][s]==0){
                    
        //         }else{
        //             and=mat[s][d];

        //         }
        //     }
        // }

        return ans; 
    }
    class Pair{
        int v1,v2;
        public Pair(int v1,int v2){
            this.v1=v1;
            this.v2=v2;
        }
    }
}