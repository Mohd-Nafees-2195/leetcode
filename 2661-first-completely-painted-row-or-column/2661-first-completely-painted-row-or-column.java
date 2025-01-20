class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        Map<Integer,Node> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new Node(i,j));
            }
        }
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                Node node=map.get(arr[i]);
                row[node.r]++;
                col[node.c]++;
                if(row[node.r]==m||col[node.c]==n)
                 return i;
            }
        }
        return 0;
    }
    public class Node{
        int r,c;
        public Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}