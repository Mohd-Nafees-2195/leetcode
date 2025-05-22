class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(q1,q2)->q2[1]-q1[1]);
        Queue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // for(int i=0;i<queries.length;i++){
        //     System.out.println(queries[i][0]+" - "+queries[i][1]);
        // }
        int n=nums.length;
        int qlen=queries.length;
        int cnt=0;
        int[] diff=new int[n];
        for(int i=0;i<qlen;i++){
            q.add(queries[i]);
            while(i+1<qlen&&q.peek()[1]==queries[i+1][1]){
                q.add(queries[i+1]);i++;
            }
            while(!q.isEmpty()){
                int[] arr=q.poll();
                // System.out.println(arr[0]+" - "+arr[1]);
                boolean flage=false;
                for(int j=arr[0];j<=arr[1];j++){
                    if(nums[j]!=0){
                        nums[j]--;
                        flage=true;
                    }
                }
                if(flage==false) {
                    cnt+=q.size()+1;
                    q.clear();
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0) return -1;
        }
        return cnt;
    }
    // public boolean check(int[] diff,int[] nums){
    //     int sum=0;
    //     for(int i=0;i<diff.length;i++){
    //         sum+=diff[i];
    //         if(sum<nums[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}